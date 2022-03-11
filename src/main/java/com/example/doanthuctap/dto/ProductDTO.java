package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {
    private int id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String description;
    private long salePrice;
    private int quantity;
    private String image;
    private String createdAt;
    private String updatedAt;
    private boolean isDelete;
    private int categoryId;
    private String categoryName;
}
