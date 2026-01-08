package com.ramtinmoradiii.onlineshopjava.service.cms;

import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentResponse;

import java.util.List;

public interface ContentService {
    List<ContentResponse> readAll();

    ContentResponse readByName(String name);

    ContentResponse readById(Long id);

    ContentResponse create(ContentRequest request);

    ContentResponse update(Long id, ContentRequest request);

    void deleteById(Long id);
}
