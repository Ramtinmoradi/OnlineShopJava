package com.ramtinmoradiii.onlineshopjava.service.blog;

import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogRequest;
import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogResponse;
import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;

import java.util.List;

public interface BlogService {
    List<BlogResponse> readAll();

    List<BlogResponse> readAllByStatus(BlogStatus status);

    BlogResponse readById(Long id);

    BlogResponse create(BlogRequest request);

    BlogResponse update(Long id, BlogRequest request);

    void deleteById(Long id);
}
