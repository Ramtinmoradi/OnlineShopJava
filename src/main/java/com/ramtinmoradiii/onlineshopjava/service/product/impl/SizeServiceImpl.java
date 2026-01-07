package com.ramtinmoradiii.onlineshopjava.service.product.impl;

import com.ramtinmoradiii.onlineshopjava.repository.product.SizeRepository;
import com.ramtinmoradiii.onlineshopjava.service.product.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;
}
