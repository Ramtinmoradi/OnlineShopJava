package com.ramtinmoradiii.onlineshopjava.service.order.impl;

import com.ramtinmoradiii.onlineshopjava.repository.order.OrderRepository;
import com.ramtinmoradiii.onlineshopjava.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
}
