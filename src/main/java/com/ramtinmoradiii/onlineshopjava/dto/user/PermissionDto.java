package com.ramtinmoradiii.onlineshopjava.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<PermissionDto> children = new ArrayList<>();
}