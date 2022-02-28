package com.example.doanthuctap.converter;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private final ModelMapper mapper;


    public CategoryConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CategoryEntity toEntity(CategoryDTO category){
        CategoryEntity categoryEntity = mapper.map(category, CategoryEntity.class);
        return categoryEntity;
    }

    public CategoryDTO toDTO(CategoryEntity category){
        CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
}
