package com.ramtinmoradiii.onlineshopjava.controller.auth;

import com.ramtinmoradiii.onlineshopjava.dto.auth.AuthResponse;
import com.ramtinmoradiii.onlineshopjava.dto.auth.LoginRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.RegisterRequest;
import com.ramtinmoradiii.onlineshopjava.dto.auth.TokenRefreshRequest;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ApiResponse.success(authService.register(request), "ثبت‌نام با موفقیت انجام شد.");
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success(authService.login(request), "ورود با موفقیت انجام شد.");
    }

    @PostMapping("/refreshToken")
    public ApiResponse<AuthResponse> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        return ApiResponse.success(authService.refreshToken(request),"توکن با موفقیت تمدید شد.");
    }
}
