package com.ramtinmoradiii.onlineshopjava.service.finance.impl;

import com.ramtinmoradiii.onlineshopjava.repository.finance.InvoiceItemRepository;
import com.ramtinmoradiii.onlineshopjava.service.finance.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceItemServiceImpl implements InvoiceItemService {
    private final InvoiceItemRepository invoiceItemRepository;
}
