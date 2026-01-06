package com.ramtinmoradiii.onlineshopjava.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVariantResponse {
    private Long id;
    private String colorName;
    private String colorHex;
    private String sizeValue;
    private Integer quantity;
    private Long finalPrice;
}