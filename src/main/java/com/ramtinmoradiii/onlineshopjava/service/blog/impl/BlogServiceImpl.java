package com.ramtinmoradiii.onlineshopjava.service.blog.impl;

import com.ramtinmoradiii.onlineshopjava.repository.blog.BlogRepository;
import com.ramtinmoradiii.onlineshopjava.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
}
