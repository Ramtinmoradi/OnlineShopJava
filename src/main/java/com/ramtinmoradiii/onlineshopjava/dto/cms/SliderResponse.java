package com.ramtinmoradiii.onlineshopjava.dto.cms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SliderResponse {
    private Long id;
    private String title;
    private String link;
    private Integer itemOrder;
    private boolean enable;
    private String imageUrl;
}