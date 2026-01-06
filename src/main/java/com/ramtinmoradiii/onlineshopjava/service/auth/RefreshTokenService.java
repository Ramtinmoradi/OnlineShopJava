package com.ramtinmoradiii.onlineshopjava.service.auth;

import com.ramtinmoradiii.onlineshopjava.entity.user.RefreshToken;
import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);
    RefreshToken createRefreshToken(Long userId);
    RefreshToken verifyExpiration(RefreshToken token);
    int deleteByUserId(Long userId);
}