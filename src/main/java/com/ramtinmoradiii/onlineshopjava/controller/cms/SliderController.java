package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.service.cms.SliderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
@RequiredArgsConstructor
public class SliderController {
    private final SliderService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ApiResponse<List<SliderResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping
    public ApiResponse<List<SliderResponse>> getAllActive() {
        return ApiResponse.success(service.getAllActive());
    }

    @GetMapping("/{id}")
    public ApiResponse<SliderResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<SliderResponse> create(@RequestBody SliderRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<SliderResponse> update(@PathVariable Long id, @RequestBody SliderRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
