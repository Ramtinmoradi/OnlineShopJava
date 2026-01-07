package com.ramtinmoradiii.onlineshopjava.service.product.impl;

import com.ramtinmoradiii.onlineshopjava.repository.product.CategoryRepository;
import com.ramtinmoradiii.onlineshopjava.service.product.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
}
