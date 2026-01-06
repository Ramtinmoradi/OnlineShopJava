package com.ramtinmoradiii.onlineshopjava.dto.user;

import lombok.Data;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String mobile;
    private boolean enable;
    private Set<RoleDto> roles;
    private CustomerDto customer;
}