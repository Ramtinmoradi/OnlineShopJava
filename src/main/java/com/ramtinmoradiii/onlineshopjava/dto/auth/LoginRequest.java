package com.ramtinmoradiii.onlineshopjava.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "نام کاربری نمی‌تواند خالی باشد")
    private String username;

    @NotBlank(message = "رمز عبور نمی‌تواند خالی باشد")
    private String password;
}