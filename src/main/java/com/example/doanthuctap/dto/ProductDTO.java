package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private String code;
    private String content;
    private int regularPrice;
    private int salePrice;
    private int originalPrice;
    private int quantity;
    private String attributes;
    private String image;
    private Date createdAt;
    private Date updatedAt;

}
