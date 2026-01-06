package com.ramtinmoradiii.onlineshopjava.dto.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResponse {
    private Long id;
    private String productTitle;
    private String colorName;
    private String sizeValue;
    private Integer quantity;
    private Long finalPrice;
}