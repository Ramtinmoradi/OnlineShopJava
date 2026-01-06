package com.ramtinmoradiii.onlineshopjava.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
}
