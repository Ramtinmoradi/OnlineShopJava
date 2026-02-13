package com.ramtinmoradiii.onlineshopjava.service.cms.impl;

import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderResponse;
import com.ramtinmoradiii.onlineshopjava.entity.cms.Slider;
import com.ramtinmoradiii.onlineshopjava.entity.common.Attachment;
import com.ramtinmoradiii.onlineshopjava.exception.ResourceNotFoundException;
import com.ramtinmoradiii.onlineshopjava.repository.cms.SliderRepository;
import com.ramtinmoradiii.onlineshopjava.repository.common.AttachmentRepository;
import com.ramtinmoradiii.onlineshopjava.service.cms.SliderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SliderServiceImpl implements SliderService {

    private final SliderRepository sliderRepository;
    private final AttachmentRepository fileRepository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public SliderResponse create(SliderRequest request) {
        Slider slider = mapper.map(request, Slider.class);

        Attachment image = fileRepository.findById(request.getImageId())
                .orElseThrow(() -> new ResourceNotFoundException("تصویر یافت نشد"));
        slider.setImage(image);

        Slider savedSlider = sliderRepository.save(slider);

        return mapToResponse(savedSlider);
    }

    @Override
    @Transactional
    public SliderResponse update(Long id, SliderRequest request) {
        Slider slider = sliderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("اسلایدر یافت نشد"));

        mapper.map(request, slider);

        if (!slider.getImage().getId().equals(request.getImageId())) {
            Attachment newImage = fileRepository.findById(request.getImageId())
                    .orElseThrow(() -> new ResourceNotFoundException("تصویر جدید یافت نشد"));
            slider.setImage(newImage);
        }

        return mapToResponse(sliderRepository.save(slider));
    }

    @Override
    public void deleteById(Long id) {
        if (!sliderRepository.existsById(id)) throw new ResourceNotFoundException("اسلایدر یافت نشد");
        sliderRepository.deleteById(id);
    }

    @Override
    public SliderResponse getById(Long id) {
        return sliderRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new ResourceNotFoundException("اسلایدر یافت نشد"));
    }

    @Override
    public List<SliderResponse> getAllActive() {
        return sliderRepository.findAllByEnableTrueOrderByItemOrderAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SliderResponse> getAll() {
        return sliderRepository.findAll(Sort.by(Sort.Direction.ASC, "itemOrder"))
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private SliderResponse mapToResponse(Slider slider) {
        SliderResponse response = mapper.map(slider, SliderResponse.class);

        if (slider.getImage() != null) {
            response.setImageUrl(slider.getImage().getPath());
        }

        return response;
    }
}