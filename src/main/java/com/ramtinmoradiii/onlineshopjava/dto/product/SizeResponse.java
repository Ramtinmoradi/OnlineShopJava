package com.ramtinmoradiii.onlineshopjava.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SizeResponse {
    private Long id;
    private String value;
}
