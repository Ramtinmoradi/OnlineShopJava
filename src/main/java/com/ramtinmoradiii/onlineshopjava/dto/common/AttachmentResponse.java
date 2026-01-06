package com.ramtinmoradiii.onlineshopjava.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachmentResponse {
    private Long id;
    private String fileName;
    private String fileType;
    private String url;
    private Long size;
}