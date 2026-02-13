package com.ramtinmoradiii.onlineshopjava.controller.blog;

import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogRequest;
import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import com.ramtinmoradiii.onlineshopjava.security.annotaion.IsAdmin;
import com.ramtinmoradiii.onlineshopjava.service.blog.BlogService;
import com.ramtinmoradiii.onlineshopjava.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.Blog.BASE)
@RequiredArgsConstructor
public class BlogController {
    private final BlogService service;

    @GetMapping
    public ApiResponse<List<BlogResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping(ApiPaths.Blog.SEARCH_BY_STATUS)
    public ApiResponse<List<BlogResponse>> getAllByStatus(@PathVariable BlogStatus status) {
        return ApiResponse.success(service.readAllByStatus(status));
    }

    @GetMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<BlogResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @IsAdmin
    @PostMapping
    public ApiResponse<BlogResponse> create(@RequestBody BlogRequest blogRequest) {
        return ApiResponse.success(service.create(blogRequest));
    }

    @IsAdmin
    @PutMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<BlogResponse> update(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        return ApiResponse.success(service.update(id, blogRequest));
    }

    @IsAdmin
    @DeleteMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<BlogResponse> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
