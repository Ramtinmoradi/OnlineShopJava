package com.ramtinmoradiii.onlineshopjava.dto.user;

import lombok.Data;

@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
}