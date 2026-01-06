package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
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