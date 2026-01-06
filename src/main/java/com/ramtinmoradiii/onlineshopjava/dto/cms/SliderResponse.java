package com.ramtinmoradiii.onlineshopjava.dto.cms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SliderResponse {
    private Long id;
    private String title;
    private String link;
    private Integer itemOrder;
    private boolean enable;
    private String imageUrl;
}