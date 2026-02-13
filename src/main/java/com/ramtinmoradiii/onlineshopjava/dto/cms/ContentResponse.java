package com.ramtinmoradiii.onlineshopjava.dto.cms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponse {
    private Long id;
    private String name;
    private String value;
}