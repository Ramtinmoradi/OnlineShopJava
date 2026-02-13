package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.security.annotaion.IsAdmin;
import com.ramtinmoradiii.onlineshopjava.service.cms.NavigationService;
import com.ramtinmoradiii.onlineshopjava.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.Navigation.BASE)
@RequiredArgsConstructor
public class NavigationController {
    private final NavigationService service;

    @IsAdmin
    @GetMapping(ApiPaths.Common.BY_ALL)
    public ApiResponse<List<NavigationResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping
    public ApiResponse<List<NavigationResponse>> getAllActive() {
        return ApiResponse.success(service.readAllActive());
    }

    @GetMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<NavigationResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @IsAdmin
    @PostMapping
    public ApiResponse<NavigationResponse> create(@RequestBody NavigationRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @IsAdmin
    @PutMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<NavigationResponse> updateById(@PathVariable Long id, @RequestBody NavigationRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @IsAdmin
    @DeleteMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
