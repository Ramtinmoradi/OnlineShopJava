package com.ramtinmoradiii.onlineshopjava.dto.auth;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthResponse {
    private String token;
    private String username;
    private String refreshToken;
    private Set<String> roles;
    private Long userId;
}