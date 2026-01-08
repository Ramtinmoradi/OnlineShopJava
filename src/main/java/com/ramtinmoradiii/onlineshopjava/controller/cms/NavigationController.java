package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.service.cms.NavigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navigation")
@RequiredArgsConstructor
public class NavigationController {
    private final NavigationService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ApiResponse<List<NavigationResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping
    public ApiResponse<List<NavigationResponse>> getAllActive() {
        return ApiResponse.success(service.readAllActive());
    }

    @GetMapping("/{id}")
    public ApiResponse<NavigationResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<NavigationResponse> create(@RequestBody NavigationRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ApiResponse<NavigationResponse> updateById(@PathVariable Long id, @RequestBody NavigationRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
