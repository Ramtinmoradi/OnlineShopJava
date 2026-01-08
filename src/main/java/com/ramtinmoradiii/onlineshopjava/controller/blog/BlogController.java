package com.ramtinmoradiii.onlineshopjava.controller.blog;

import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogRequest;
import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import com.ramtinmoradiii.onlineshopjava.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService service;

    @GetMapping
    public ApiResponse<List<BlogResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping("/key/{status}")
    public ApiResponse<List<BlogResponse>> getAllByStatus(@PathVariable BlogStatus status) {
        return ApiResponse.success(service.readAllByStatus(status));
    }

    @GetMapping("/{id}")
    public ApiResponse<BlogResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<BlogResponse> create(@RequestBody BlogRequest blogRequest) {
        return ApiResponse.success(service.create(blogRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<BlogResponse> update(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        return ApiResponse.success(service.update(id, blogRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<BlogResponse> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
