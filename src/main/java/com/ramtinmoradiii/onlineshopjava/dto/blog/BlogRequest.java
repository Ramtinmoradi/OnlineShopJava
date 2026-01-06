package com.ramtinmoradiii.onlineshopjava.dto.blog;

import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class BlogRequest {
    @NotBlank(message = "عنوان مقاله الزامی است")
    private String title;

    @NotBlank(message = "زیرعنوان الزامی است")
    private String subTitle;

    @NotBlank(message = "متن مقاله الزامی است")
    private String description;

    @NotNull(message = "وضعیت مقاله باید مشخص شود")
    private BlogStatus status;

    private Set<Long> attachmentIds;
}