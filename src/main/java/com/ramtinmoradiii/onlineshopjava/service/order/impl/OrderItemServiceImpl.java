package com.ramtinmoradiii.onlineshopjava.service.order.impl;

import com.ramtinmoradiii.onlineshopjava.repository.order.OrderItemRepository;
import com.ramtinmoradiii.onlineshopjava.service.order.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
}
