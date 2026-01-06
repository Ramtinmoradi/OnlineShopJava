package com.ramtinmoradiii.onlineshopjava.dto.user;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String mobile;
    private String email;
    private boolean enable;
    private String fullName;
    private Set<String> roles;
    private String registeredAt;
}