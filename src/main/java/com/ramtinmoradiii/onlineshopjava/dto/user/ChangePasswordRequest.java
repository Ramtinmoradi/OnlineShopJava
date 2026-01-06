package com.ramtinmoradiii.onlineshopjava.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @NotBlank(message = "رمز عبور فعلی الزامی است")
    private String currentPassword;

    @NotBlank(message = "رمز عبور جدید الزامی است")
    @Size(min = 6, message = "رمز عبور جدید باید حداقل ۶ کاراکتر باشد")
    private String newPassword;

    @NotBlank(message = "تکرار رمز عبور جدید الزامی است")
    private String confirmNewPassword;
}