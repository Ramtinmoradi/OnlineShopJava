package com.ramtinmoradiii.onlineshopjava.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

public class RoleDto {

    @Data
    public static class Request {
        @NotBlank(message = "نام نقش الزامی است")
        private String name;

        private String description;
    }

    @Data
    @Builder
    public static class Response {
        private Long id;
        private String name;
        private String description;
    }
}