package com.ramtinmoradiii.onlineshopjava.dto.finance;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaymentGatewayRequest {
    @NotBlank(message = "نام درگاه الزامی است")
    private String name;

    @NotBlank(message = "کد سیستمی درگاه الزامی است")
    private String code;

    private String description;

    private boolean enable;

    private String merchantId;
    private String apiKey;

    private Integer orderItem;
}