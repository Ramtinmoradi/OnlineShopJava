package com.ramtinmoradiii.onlineshopjava.dto.cms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NavigationRequest {
    @NotBlank(message = "عنوان نباید خالی باشد")
    private String title;

    @NotBlank(message = "لینک نباید خالی باشد")
    private String link;

    private Integer orderNumber;
    private boolean enable;
}