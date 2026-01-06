package com.ramtinmoradiii.onlineshopjava.dto.finance;

import com.ramtinmoradiii.onlineshopjava.entity.finance.enums.InvoiceStatus;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class InvoiceResponse {
    private Long id;
    private String number;
    private String customerName;

    private Long totalAmount;
    private Long shippingCost;
    private InvoiceStatus status;

    private String issuedAt;
    private String paidAt;

    private List<InvoiceItemResponse> items;

    private String fullAddress;
    private String postalCode;
}