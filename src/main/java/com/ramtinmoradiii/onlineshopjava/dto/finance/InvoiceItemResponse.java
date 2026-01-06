package com.ramtinmoradiii.onlineshopjava.dto.finance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceItemResponse {
    private String productTitle;
    private String colorName;
    private String sizeValue;
    private Integer quantity;
    private Long unitPrice;
    private Long totalPrice; // quantity * unitPrice
}