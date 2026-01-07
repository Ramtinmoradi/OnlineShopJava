package com.ramtinmoradiii.onlineshopjava.service.product.impl;

import com.ramtinmoradiii.onlineshopjava.repository.product.ProductVariantRepository;
import com.ramtinmoradiii.onlineshopjava.service.product.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {
    private final ProductVariantRepository productVariantRepository;
}
