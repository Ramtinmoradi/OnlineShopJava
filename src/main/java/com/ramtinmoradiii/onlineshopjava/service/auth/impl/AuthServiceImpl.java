package com.ramtinmoradiii.onlineshopjava.service.auth.impl;

import com.ramtinmoradiii.onlineshopjava.dto.auth.AuthResponse;
import com.ramtinmoradiii.onlineshopjava.dto.auth.LoginRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.RegisterRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.TokenRefreshRequest;
import com.ramtinmoradiii.onlineshopjava.entity.user.Customer;
import com.ramtinmoradiii.onlineshopjava.entity.user.RefreshToken;
import com.ramtinmoradiii.onlineshopjava.entity.user.Role;
import com.ramtinmoradiii.onlineshopjava.entity.user.User;
import com.ramtinmoradiii.onlineshopjava.exception.AlreadyExistsException;
import com.ramtinmoradiii.onlineshopjava.repository.user.RoleRepository;
import com.ramtinmoradiii.onlineshopjava.repository.user.UserRepository;
import com.ramtinmoradiii.onlineshopjava.security.JwtUtils;
import com.ramtinmoradiii.onlineshopjava.service.auth.AuthService;
import com.ramtinmoradiii.onlineshopjava.service.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        validateNewUser(request);

        User user = modelMapper.map(request, User.class);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEnable(true);

        Role customerRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("خطای سیستمی: نقش کاربر (ROLE_USER) یافت نشد."));
        user.setRoles(new HashSet<>(Set.of(customerRole)));

        Customer customer = modelMapper.map(request, Customer.class);

        user.setCustomer(customer);
        customer.setUser(user);

        User savedUser = userRepository.save(user);

        String jwtToken = jwtUtils.generateToken(savedUser.getUsername());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(savedUser.getId());

        return buildAuthResponse(savedUser, jwtToken, refreshToken.getToken());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("کاربر یافت نشد."));

        String jwtToken = jwtUtils.generateToken(user.getUsername());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

        return buildAuthResponse(user, jwtToken, refreshToken.getToken());
    }

    @Override
    public AuthResponse refreshToken(TokenRefreshRequest request) {
        return refreshTokenService
                .findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String newAccessToken = jwtUtils.generateToken(user.getUsername());
                    return buildAuthResponse(user, newAccessToken, request.getRefreshToken());
                })
                .orElseThrow(() -> new RuntimeException("Refresh token is not in database!"));
    }

    private AuthResponse buildAuthResponse(User user, String accessToken, String refreshToken) {
        return AuthResponse.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .username(user.getUsername())
                .userId(user.getId())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .build();
    }

    private void validateNewUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AlreadyExistsException("این نام کاربری قبلاً گرفته شده است.");
        }
        if (userRepository.existsByMobile(request.getMobile())) {
            throw new AlreadyExistsException("این شماره موبایل قبلاً ثبت‌نام کرده است.");
        }
        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new AlreadyExistsException("این ایمیل قبلاً استفاده شده است.");
            }
        }
    }
}