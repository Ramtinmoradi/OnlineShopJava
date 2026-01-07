package com.ramtinmoradiii.onlineshopjava.service.cms.impl;

import com.ramtinmoradiii.onlineshopjava.repository.cms.NavigationRepository;
import com.ramtinmoradiii.onlineshopjava.service.cms.NavigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NavigationServiceImpl implements NavigationService {
    private final NavigationRepository navigationRepository;
}
