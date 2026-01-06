package com.ramtinmoradiii.onlineshopjava.dto.blog;

import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private Long visitCount;
    private BlogStatus status;
    private String publishDate;
    private List<String> imageUrls;
}