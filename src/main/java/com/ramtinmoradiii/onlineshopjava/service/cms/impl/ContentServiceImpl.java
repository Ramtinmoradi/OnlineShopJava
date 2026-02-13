package com.ramtinmoradiii.onlineshopjava.service.cms.impl;

import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.ContentResponse;
import com.ramtinmoradiii.onlineshopjava.entity.cms.Content;
import com.ramtinmoradiii.onlineshopjava.exception.ResourceNotFoundException;
import com.ramtinmoradiii.onlineshopjava.repository.cms.ContentRepository;
import com.ramtinmoradiii.onlineshopjava.service.cms.ContentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ContentResponse> readAll() {
        return repository.findAll()
                .stream()
                .map(item -> mapper.map(item, ContentResponse.class))
                .toList();
    }

    @Override
    public ContentResponse readByName(String name) {
        return mapper.map(
                repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("ایتم مورد نظر یافت نشد.")),
                ContentResponse.class
        );
    }

    @Override
    public ContentResponse readById(Long id) {
        return mapper.map(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ایتم مورد نظر یافت نشد.")),
                ContentResponse.class
        );
    }

    @Override
    public ContentResponse create(ContentRequest request) {
        return mapper.map(
                repository.save(mapper.map(request, Content.class)),
                ContentResponse.class
        );
    }

    @Override
    public ContentResponse update(Long id, ContentRequest request) {
        return mapper.map(
                repository.save(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ایتم مورد نظر یافت نشد."))),
                ContentResponse.class
        );
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("ایتم مورد نظر یافت نشد.");
        repository.deleteById(id);
    }
}
