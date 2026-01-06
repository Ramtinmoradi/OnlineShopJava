package com.ramtinmoradiii.onlineshopjava.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenRefreshRequest {
    @NotBlank(message = "ریفرش توکن نمی‌تواند خالی باشد")
    private String refreshToken;
}