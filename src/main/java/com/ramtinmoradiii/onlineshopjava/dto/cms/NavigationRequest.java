package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NavigationRequest {
    @NotBlank(message = "عنوان نباید خالی باشد")
    private String title;

    @NotBlank(message = "لینک نباید خالی باشد")
    private String link;

    private Integer orderNumber;
    private boolean enable;
}