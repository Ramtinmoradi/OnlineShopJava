package com.ramtinmoradiii.onlineshopjava.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDto {
    private Long id;

    @NotBlank(message = "نام نقش نمی‌تواند خالی باشد")
    private String name;

    private String description;
    private Set<PermissionDto> permissions = new HashSet<>();
}