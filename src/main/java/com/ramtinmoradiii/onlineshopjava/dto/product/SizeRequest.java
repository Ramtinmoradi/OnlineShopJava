package com.ramtinmoradiii.onlineshopjava.dto.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SizeRequest {
    @NotBlank(message = "عنوان سایز الزامی است")
    private String value;
}