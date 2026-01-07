package com.ramtinmoradiii.onlineshopjava.service.product.impl;

import com.ramtinmoradiii.onlineshopjava.repository.product.ColorRepository;
import com.ramtinmoradiii.onlineshopjava.service.product.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;
}
