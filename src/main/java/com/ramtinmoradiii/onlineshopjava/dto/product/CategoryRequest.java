package com.ramtinmoradiii.onlineshopjava.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotBlank(message = "عنوان دسته‌بندی الزامی است")
    private String title;

    private String description;

    private boolean enable;

    @NotNull(message = "تصویر دسته‌بندی الزامی است")
    private Long imageId;
}