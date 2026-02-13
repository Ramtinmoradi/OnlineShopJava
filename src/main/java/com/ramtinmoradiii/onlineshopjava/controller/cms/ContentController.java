package com.ramtinmoradiii.onlineshopjava.controller.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.security.annotaion.IsAdmin;
import com.ramtinmoradiii.onlineshopjava.service.cms.ContentService;
import com.ramtinmoradiii.onlineshopjava.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.Content.BASE)
@RequiredArgsConstructor
public class ContentController {
    private final ContentService service;

    @GetMapping
    public ApiResponse<List<ContentResponse>> getAll() {
        return ApiResponse.success(service.readAll());
    }

    @GetMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<ContentResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.readById(id));
    }

    @GetMapping(ApiPaths.Content.SEARCH_BY_NAME)
    public ApiResponse<ContentResponse> getByName(@PathVariable String name) {
        return ApiResponse.success(service.readByName(name));
    }

    @IsAdmin
    @PostMapping
    public ApiResponse<ContentResponse> create(@RequestBody ContentRequest contentRequest) {
        return ApiResponse.success(service.create(contentRequest));
    }

    @IsAdmin
    @PutMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<ContentResponse> update(@PathVariable Long id, @RequestBody ContentRequest contentRequest) {
        return ApiResponse.success(service.update(id, contentRequest));
    }

    @IsAdmin
    @DeleteMapping(ApiPaths.Common.BY_ID)
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ApiResponse.success();
    }
}
