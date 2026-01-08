package com.ramtinmoradiii.onlineshopjava.service.cms.impl;

import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.NavigationResponse;
import com.ramtinmoradiii.onlineshopjava.entity.cms.Navigation;
import com.ramtinmoradiii.onlineshopjava.entity.common.Attachment;
import com.ramtinmoradiii.onlineshopjava.exception.NotFoundException;
import com.ramtinmoradiii.onlineshopjava.repository.cms.NavigationRepository;
import com.ramtinmoradiii.onlineshopjava.service.cms.NavigationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NavigationServiceImpl implements NavigationService {
    private final NavigationRepository repository;
    private final ModelMapper mapper;

    @Override
    public NavigationResponse create(NavigationRequest request) {
        return mapper.map(
                repository.save(mapper.map(request, Navigation.class)),
                NavigationResponse.class
        );
    }

    @Override
    public NavigationResponse update(Long id, NavigationRequest request) {
        return mapper.map(
                repository.save(repository.findById(id).orElseThrow(() -> new NotFoundException("نویگیشن یافت نشد."))),
                NavigationResponse.class
        );
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) throw new NotFoundException("نویگیشن یافت نشد.");
        repository.deleteById(id);
    }

    @Override
    public List<NavigationResponse> readAllActive() {
        return repository
                .findAllByEnableTrueOrderByOrderNumberAsc()
                .stream()
                .map(item -> mapper.map(item, NavigationResponse.class))
                .toList();
    }

    @Override
    public List<NavigationResponse> readAll() {
        return repository.findAll()
                .stream()
                .map(item -> mapper.map(item, NavigationResponse.class))
                .toList();
    }

    @Override
    public NavigationResponse readById(Long id) {
        return repository.findById(id)
                .map(item -> mapper.map(item, NavigationResponse.class))
                .orElseThrow(() -> new NotFoundException("نویگیشن یافت نشد"));
    }


}
