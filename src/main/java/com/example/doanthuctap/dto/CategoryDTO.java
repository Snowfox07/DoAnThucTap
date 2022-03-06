package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDTO {
    private int id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String createdAt;
    private String updatedAt;
    private boolean isDelete;
}
