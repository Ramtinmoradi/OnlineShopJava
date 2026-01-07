package com.ramtinmoradiii.onlineshopjava.service.finance.impl;

import com.ramtinmoradiii.onlineshopjava.repository.finance.PaymentGatewayRepository;
import com.ramtinmoradiii.onlineshopjava.service.finance.PaymentGatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
    private final PaymentGatewayRepository paymentGatewayRepository;
}
