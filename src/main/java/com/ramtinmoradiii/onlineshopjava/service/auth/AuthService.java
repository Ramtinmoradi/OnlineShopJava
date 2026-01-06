package com.ramtinmoradiii.onlineshopjava.service.auth;

import com.ramtinmoradiii.onlineshopjava.dto.auth.AuthResponse;
import com.ramtinmoradiii.onlineshopjava.dto.auth.LoginRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.RegisterRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.TokenRefreshRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refreshToken(TokenRefreshRequest request);
}