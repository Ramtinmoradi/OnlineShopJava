package com.ramtinmoradiii.onlineshopjava.dto.cms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentResponse {
    private Long id;
    private String name;
    private String value;
}