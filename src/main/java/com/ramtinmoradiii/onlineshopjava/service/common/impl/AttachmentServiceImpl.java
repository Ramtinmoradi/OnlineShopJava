package com.ramtinmoradiii.onlineshopjava.service.common.impl;

import com.ramtinmoradiii.onlineshopjava.repository.common.AttachmentRepository;
import com.ramtinmoradiii.onlineshopjava.service.common.AtachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AtachmentService {
    private final AttachmentRepository attachmentRepository;
}
