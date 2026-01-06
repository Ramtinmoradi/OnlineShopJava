package com.ramtinmoradiii.onlineshopjava.dto.user;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CustomerProfileResponse {
    private Long id;
    private String username;
    private String mobile;
    private String email;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String profileImageUrl;

    private Set<String> roles;
}