package com.ramtinmoradiii.onlineshopjava.service.cart.impl;

import com.ramtinmoradiii.onlineshopjava.repository.cart.CartRepository;
import com.ramtinmoradiii.onlineshopjava.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
}
