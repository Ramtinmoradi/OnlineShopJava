package com.ramtinmoradiii.onlineshopjava.service.product.impl;

import com.ramtinmoradiii.onlineshopjava.repository.product.ProductRepository;
import com.ramtinmoradiii.onlineshopjava.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
}
