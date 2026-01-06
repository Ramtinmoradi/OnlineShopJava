package com.ramtinmoradiii.onlineshopjava.service.auth.impl;

import com.ramtinmoradiii.onlineshopjava.entity.user.RefreshToken;
import com.ramtinmoradiii.onlineshopjava.entity.user.User;
import com.ramtinmoradiii.onlineshopjava.exception.TokenRefreshException;
import com.ramtinmoradiii.onlineshopjava.repository.user.RefreshTokenRepository;
import com.ramtinmoradiii.onlineshopjava.repository.user.UserRepository;
import com.ramtinmoradiii.onlineshopjava.service.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Value("${jwt.refreshExpirationMs}")
    private Long refreshTokenDurationMs;

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    @Transactional
    public RefreshToken createRefreshToken(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("کاربر با آیدی مورد نظر یافت نشد."));

        refreshTokenRepository.deleteByUser(user);

        RefreshToken refreshToken = RefreshToken.builder()
                .user(user)
                .expiryDate(Instant.now().plusMillis(refreshTokenDurationMs))
                .token(UUID.randomUUID().toString())
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException("توکن منقضی شده است لطفا دوباره وارد شوید.");
        }
        return token;
    }

    @Override
    @Transactional
    public int deleteByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("کاربر با آیدی مورد نظر یافت نشد."));
        return refreshTokenRepository.deleteByUser(user);
    }
}