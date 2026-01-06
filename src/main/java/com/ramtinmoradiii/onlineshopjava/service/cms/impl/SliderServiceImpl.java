package com.ramtinmoradiii.onlineshopjava.service.cms.impl;

import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderRequest;
import com.ramtinmoradiii.onlineshopjava.dto.cms.SliderResponse;
import com.ramtinmoradiii.onlineshopjava.entity.cms.Slider;
import com.ramtinmoradiii.onlineshopjava.entity.common.Attachment;
import com.ramtinmoradiii.onlineshopjava.exception.NotFoundException;
import com.ramtinmoradiii.onlineshopjava.repository.cms.SliderRepository;
import com.ramtinmoradiii.onlineshopjava.repository.common.AttachmentRepository;
import com.ramtinmoradiii.onlineshopjava.service.cms.SliderService;
import lombok.RequiredArgsConstructor;
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

    @Override
    @Transactional
    public SliderResponse create(SliderRequest request) {
        Attachment image = fileRepository.findById(request.getImageId())
                .orElseThrow(() -> new NotFoundException("تصویر یافت نشد"));

        Slider slider = Slider.builder()
                .title(request.getTitle())
                .link(request.getLink())
                .enable(request.isEnable())
                .itemOrder(request.getItemOrder())
                .image(image)
                .build();

        Slider savedSlider = sliderRepository.save(slider);

        return mapToResponse(savedSlider);
    }

    @Override
    @Transactional
    public SliderResponse update(Long id, SliderRequest request) {
        Slider slider = sliderRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("اسلایدر یافت نشد"));

        if (!slider.getImage().getId().equals(request.getImageId())) {
            Attachment newImage = fileRepository.
                    findById(request.getImageId())
                    .orElseThrow(() -> new NotFoundException("تصویر جدید یافت نشد"));
            slider.setImage(newImage);
        }

        slider.setTitle(request.getTitle());
        slider.setLink(request.getLink());
        slider.setEnable(request.isEnable());
        slider.setItemOrder(request.getItemOrder());

        return mapToResponse(sliderRepository.save(slider));
    }

    @Override
    public void delete(Long id) {
        if (!sliderRepository.existsById(id)) {
            throw new NotFoundException("اسلایدر یافت نشد");
        }
        sliderRepository.deleteById(id);
    }

    @Override
    public SliderResponse getById(Long id) {
        return sliderRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new NotFoundException("اسلایدر یافت نشد"));
    }

    @Override
    public List<SliderResponse> getAllActive() {
        return sliderRepository.findAllByEnableTrueOrderByOrderItemAsc()
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
        return SliderResponse.builder()
                .id(slider.getId())
                .title(slider.getTitle())
                .link(slider.getLink())
                .enable(slider.isEnable())
                .itemOrder(slider.getItemOrder())
                .imageUrl(slider.getImage() != null ? slider.getImage().getPath() : null)
                .build();
    }
}