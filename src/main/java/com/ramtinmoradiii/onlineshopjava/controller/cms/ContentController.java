package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.service.cms.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService service;

    @GetMapping
    public ApiResponse<List<ContentResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<ContentResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @GetMapping("/key/{name}")
    public ApiResponse<ContentResponse> getByName(@PathVariable String name) {
        return ApiResponse.success(service.readByName(name));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<ContentResponse> create(@RequestBody ContentRequest contentRequest) {
        return ApiResponse.success(service.create(contentRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<ContentResponse> update(@PathVariable Long id, @RequestBody ContentRequest contentRequest) {
        return ApiResponse.success(service.update(id, contentRequest));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
