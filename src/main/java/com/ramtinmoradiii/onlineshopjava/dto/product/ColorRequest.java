package com.ramtinmoradiii.onlineshopjava.dto.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ColorRequest {
    @NotBlank(message = "نام رنگ الزامی است")
    private String name;

    @NotBlank(message = "کد رنگ الزامی است")
    private String value;
}