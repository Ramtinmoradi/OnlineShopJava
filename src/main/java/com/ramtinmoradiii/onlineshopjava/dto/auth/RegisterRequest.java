package com.ramtinmoradiii.onlineshopjava.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "نام کاربری الزامی است")
    @Size(min = 4, max = 20, message = "نام کاربری باید بین ۴ تا ۲۰ کاراکتر باشد")
    private String username;

    @Email(message = "فرمت ایمیل صحیح نیست")
    private String email;

    @NotBlank(message = "رمز عبور الزامی است")
    @Size(min = 8, message = "رمز عبور باید حداقل 8 کاراکتر باشد")
    private String password;

    @NotBlank(message = "شماره موبایل الزامی است")
    @Size(min = 11, max = 11, message = "شماره موبایل باید ۱۱ رقم باشد")
    @Pattern(regexp = "^09\\d{9}$", message = "فرمت شماره موبایل صحیح نیست (مثال: 09123456789)")
    private String mobile;

    private String firstName;
    private String lastName;
}