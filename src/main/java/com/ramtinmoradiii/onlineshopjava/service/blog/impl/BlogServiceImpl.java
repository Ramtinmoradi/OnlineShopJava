package com.ramtinmoradiii.onlineshopjava.service.blog.impl;

import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogRequest;
import com.ramtinmoradiii.onlineshopjava.dto.blog.BlogResponse;
import com.ramtinmoradiii.onlineshopjava.entity.blog.Blog;
import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import com.ramtinmoradiii.onlineshopjava.exception.ResourceNotFoundException;
import com.ramtinmoradiii.onlineshopjava.repository.blog.BlogRepository;
import com.ramtinmoradiii.onlineshopjava.repository.common.AttachmentRepository;
import com.ramtinmoradiii.onlineshopjava.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository repository;
    private final AttachmentRepository fileRepository;
    private final ModelMapper mapper;

    @Override
    public List<BlogResponse> readAll() {
        return repository.findAll()
                .stream()
                .map(item -> mapper.map(item, BlogResponse.class))
                .toList();
    }

    @Override
    public List<BlogResponse> readAllByStatus(BlogStatus status) {
        return repository.findAllByStatus(status)
                .stream()
                .map(item -> mapper.map(item, BlogResponse.class))
                .toList();
    }

    @Override
    public BlogResponse readById(Long id) {
        return mapper.map(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("بلاگ مورد نظر یافت نشد.")),
                BlogResponse.class
        );
    }

    @Override
    public BlogResponse create(BlogRequest request) {
        return mapper.map(
                repository.save(mapper.map(request, Blog.class)),
                BlogResponse.class
        );
    }

    @Override
    public BlogResponse update(Long id, BlogRequest request) {
        return mapper.map(
                repository.save(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("بلاگ مورد نظر یافت نشد."))),
                BlogResponse.class
        );
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("بلاگ مورد نظر یافت نشد.");
        repository.deleteById(id);
    }
}
