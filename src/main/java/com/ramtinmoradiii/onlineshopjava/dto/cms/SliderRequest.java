package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderRequest {
    @NotBlank(message = "عنوان اسلایدر نمی‌تواند خالی باشد")
    private String title;

    @NotBlank(message = "لینک اسلایدر نمی‌تواند خالی باشد")
    private String link;

    private Integer itemOrder;

    private boolean enable;

    @NotNull(message = "شناسه تصویر الزامی است")
    private Long imageId;
}