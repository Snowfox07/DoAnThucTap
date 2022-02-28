package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDTO {
    private int id;
    private String name;
    private int orderIndex;
    private int parent;
    private String slug;
    private Date createAt;
    private Date updateAt;
}
