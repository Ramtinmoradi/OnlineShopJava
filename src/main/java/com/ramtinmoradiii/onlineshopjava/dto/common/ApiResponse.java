package com.ramtinmoradiii.onlineshopjava.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private List<ValidationError> errors;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(true, "عملیات با موفقیت انجام شد.", data, null);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(true, "عملیات با موفقیت انجام شد.", null, null);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<T>(true, message, data, null);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<T>(true, message, null, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(false, message, null, null);
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<T>(false, message, data, null);
    }

    public static <T> ApiResponse<T> validationError(List<ValidationError> errors) {
        return new ApiResponse<T>(false, "اطلاعات ورودی نامعتبر است.", null, errors);
    }
}
