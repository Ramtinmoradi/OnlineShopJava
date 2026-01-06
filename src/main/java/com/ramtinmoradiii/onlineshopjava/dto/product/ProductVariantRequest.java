package com.ramtinmoradiii.onlineshopjava.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductVariantRequest {
    @NotNull(message = "محصول باید مشخص باشد")
    private Long productId;

    private Long colorId;
    private Long sizeId;

    @NotNull
    @Min(1)
    private Integer quantity;

    private Long priceOverride;
    private String sku;
}