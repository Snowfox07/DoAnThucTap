package com.example.doanthuctap.converter;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.entity.CategoryEntity;
import com.example.doanthuctap.entity.ProductEntity;
import com.example.doanthuctap.repository.CategoryRepository;
import com.example.doanthuctap.service.implement.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private final ModelMapper mapper;

    public ProductConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductEntity toEntity(ProductDTO productDTO){
        ProductEntity productEntity = mapper.map(productDTO, ProductEntity.class);
        return productEntity;
    }

    public ProductDTO toDTO(ProductEntity productEntity){
        ProductDTO productDTO = mapper.map(productEntity, ProductDTO.class);
        return productDTO;
    }

}
