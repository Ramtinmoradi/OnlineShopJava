package com.ramtinmoradiii.onlineshopjava.dto.cart;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class CartItemResponse {
    private Long id;
    private String productTitle;
    private String variantInfo;
    private String imageUrl;
    private Integer quantity;
    private Long pricePerUnit;
    private Long totalPrice;
}