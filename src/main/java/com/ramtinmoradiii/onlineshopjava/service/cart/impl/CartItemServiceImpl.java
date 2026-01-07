package com.ramtinmoradiii.onlineshopjava.service.cart.impl;

import com.ramtinmoradiii.onlineshopjava.repository.cart.CartItemRepository;
import com.ramtinmoradiii.onlineshopjava.service.cart.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
}
