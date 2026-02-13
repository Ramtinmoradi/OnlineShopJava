package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.security.annotaion.IsAdmin;
import com.ramtinmoradiii.onlineshopjava.service.cms.SliderService;
import com.ramtinmoradiii.onlineshopjava.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.Slider.BASE)
@RequiredArgsConstructor
public class SliderController {
    private final SliderService service;

    @IsAdmin
    @GetMapping(ApiPaths.Common.BY_ALL)
    public ApiResponse<List<SliderResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping
    public ApiResponse<List<SliderResponse>> getAllActive() {
        return ApiResponse.success(service.getAllActive());
    }

    @GetMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<SliderResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @IsAdmin
    @PostMapping
    public ApiResponse<SliderResponse> create(@RequestBody SliderRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @IsAdmin
    @PutMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<SliderResponse> update(@PathVariable Long id, @RequestBody SliderRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @IsAdmin
    @DeleteMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
