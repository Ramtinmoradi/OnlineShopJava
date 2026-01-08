package com.ramtinmoradiii.onlineshopjava.service.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationResponse;

import java.util.List;

public interface NavigationService {
    NavigationResponse create(NavigationRequest request);

    NavigationResponse update(Long id, NavigationRequest request);

    void deleteById(Long id);

    List<NavigationResponse> readAllActive();

    List<NavigationResponse> readAll();

    NavigationResponse readById(Long id);

}
