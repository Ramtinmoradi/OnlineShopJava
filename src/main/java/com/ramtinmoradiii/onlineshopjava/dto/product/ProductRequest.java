package com.ramtinmoradiii.onlineshopjava.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class ProductRequest {
    @NotBlank(message = "نام محصول الزامی است")
    private String title;

    private String description;

    @NotNull
    @Min(value = 0, message = "قیمت پایه نمی‌تواند منفی باشد")
    private Long price;

    private boolean enable;
    private boolean available;

    private Set<Long> attachmentIds;
}