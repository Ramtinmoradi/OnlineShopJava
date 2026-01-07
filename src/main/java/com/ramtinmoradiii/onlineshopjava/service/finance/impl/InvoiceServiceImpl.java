package com.ramtinmoradiii.onlineshopjava.service.finance.impl;

import com.ramtinmoradiii.onlineshopjava.repository.finance.InvoiceRepository;
import com.ramtinmoradiii.onlineshopjava.service.finance.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
}
