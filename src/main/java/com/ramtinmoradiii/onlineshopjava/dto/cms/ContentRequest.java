package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentRequest {
    @NotBlank(message = "نام کلید محتوا الزامی است")
    private String name;

    @NotBlank(message = "مقدار محتوا الزامی است")
    private String value;
}
