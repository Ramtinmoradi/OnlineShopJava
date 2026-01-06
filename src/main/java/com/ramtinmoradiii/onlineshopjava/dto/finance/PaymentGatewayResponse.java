package com.ramtinmoradiii.onlineshopjava.dto.finance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentGatewayResponse {
    private Long id;
    private String name;
    private String description;
    private String code;
    private boolean enable;
}