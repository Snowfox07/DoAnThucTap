package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    CategoryEntity save(CategoryDTO category);
    List<CategoryDTO> listCategory();
    void delete(Long id);
}
