package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentRequest {
    @NotBlank(message = "نام محتوا الزامی است")
    private String name;

    @NotBlank(message = "مقدار محتوا الزامی است")
    private String value;
}
