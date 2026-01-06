package com.ramtinmoradiii.onlineshopjava.dto.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String title;
    private String description;
    private Long basePrice;
    private boolean isAvailable;
    private Set<String> imageUrls;
    private List<ProductVariantResponse> variants;
}