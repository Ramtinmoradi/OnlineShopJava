package com.ramtinmoradiii.onlineshopjava.service.auth.impl;

import com.ramtinmoradiii.onlineshopjava.dto.auth.AuthResponse;
import com.ramtinmoradiii.onlineshopjava.dto.auth.LoginRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.RegisterRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.TokenRefreshRequest;
import com.ramtinmoradiii.onlineshopjava.entity.user.Customer;
import com.ramtinmoradiii.onlineshopjava.entity.user.RefreshToken;
import com.ramtinmoradiii.onlineshopjava.entity.user.Role;
import com.ramtinmoradiii.onlineshopjava.entity.user.User;
import com.ramtinmoradiii.onlineshopjava.entity.user.enums.RoleType;
import com.ramtinmoradiii.onlineshopjava.exception.AlreadyExistsException;
import com.ramtinmoradiii.onlineshopjava.exception.ResourceNotFoundException;
import com.ramtinmoradiii.onlineshopjava.exception.TokenRefreshException;
import com.ramtinmoradiii.onlineshopjava.repository.user.RoleRepository;
import com.ramtinmoradiii.onlineshopjava.repository.user.UserRepository;
import com.ramtinmoradiii.onlineshopjava.security.jwt.JwtUtils;
import com.ramtinmoradiii.onlineshopjava.security.service.UserDetailsImpl;
import com.ramtinmoradiii.onlineshopjava.service.auth.AuthService;
import com.ramtinmoradiii.onlineshopjava.service.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

        Role customerRole = roleRepository.findByName(RoleType.ROLE_USER.name())
                .orElseThrow(() -> new ResourceNotFoundException("این رول پیدا نشد."));

        user.setRoles(new HashSet<>(Set.of(customerRole)));

        Customer customer = modelMapper.map(request, Customer.class);
        user.setCustomer(customer);
        customer.setUser(user);

        User savedUser = userRepository.save(user);

        String jwtToken = jwtUtils.generateToken(savedUser.getUsername());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(savedUser.getId());

        Set<String> roles = savedUser.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return createAuthResponse(savedUser.getId(), savedUser.getUsername(), jwtToken, refreshToken.getToken(), roles);
    }

    @Override
    @Transactional
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateToken(userDetails.getUsername());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        return createAuthResponse(userDetails.getId(), userDetails.getUsername(), jwtToken, refreshToken.getToken(), roles);
    }

    @Override
    @Transactional
    public AuthResponse refreshToken(TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String newAccessToken = jwtUtils.generateToken(user.getUsername());
                    Set<String> roles = user.getRoles().stream()
                            .map(Role::getName)
                            .collect(Collectors.toSet());
                    return createAuthResponse(user.getId(), user.getUsername(), newAccessToken, request.getRefreshToken(), roles);
                })
                .orElseThrow(() -> new TokenRefreshException("توکن شما منقضی شده است لطفا مجدد وارد شوید."));
    }

    private AuthResponse createAuthResponse(Long id, String username, String token, String refreshToken, Set<String> roles) {
        return AuthResponse.builder()
                .userId(id)
                .username(username)
                .token(token)
                .refreshToken(refreshToken)
                .roles(roles)
                .build();
    }

    private void validateNewUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AlreadyExistsException("نام کاربری تکراری است");
        }
        if (userRepository.existsByMobile(request.getMobile())) {
            throw new AlreadyExistsException("شماره موبایل تکراری است");
        }
        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new AlreadyExistsException("ایمیل تکراری است");
            }
        }
    }
}