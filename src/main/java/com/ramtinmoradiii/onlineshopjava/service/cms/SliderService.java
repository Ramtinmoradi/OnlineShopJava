package com.ramtinmoradiii.onlineshopjava.service.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderResponse;

import java.util.List;

public interface SliderService {
    SliderResponse create(SliderRequest request);

    SliderResponse update(Long id, SliderRequest request);

    void deleteById(Long id);

    SliderResponse getById(Long id);

    List<SliderResponse> getAllActive();

    List<SliderResponse> getAll();
}