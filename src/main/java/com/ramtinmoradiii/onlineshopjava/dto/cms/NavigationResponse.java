package com.ramtinmoradiii.onlineshopjava.dto.cms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NavigationResponse {
    private Long id;
    private String title;
    private String link;
    private Integer orderNumber;
}