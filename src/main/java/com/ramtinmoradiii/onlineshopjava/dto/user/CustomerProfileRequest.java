package com.ramtinmoradiii.onlineshopjava.dto.user;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerProfileRequest {
    @Size(min = 2, message = "نام باید حداقل ۲ حرف باشد")
    private String firstName;

    @Size(min = 2, message = "نام خانوادگی باید حداقل ۲ حرف باشد")
    private String lastName;

    private String address;
    private String postalCode;

    private Long imageId;
}