package com.ramtinmoradiii.onlineshopjava.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String fullAddress;
    @NotBlank
    private String postalCode;

    @NotBlank
    private String receiverName;
    @NotBlank
    private String receiverPhone;

    @NotNull
    private Long paymentGatewayId;
}