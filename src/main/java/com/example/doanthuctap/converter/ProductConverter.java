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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    public ProductConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductEntity toEntity(ProductDTO productDTO){
        CategoryDTO categoryDTO = categoryService.findCategoryById(productDTO.getCategoryId());
        ProductEntity productEntity = mapper.map(productDTO, ProductEntity.class);
        productEntity.setCategory(categoryConverter.toEntity(categoryDTO));
        return productEntity;
    }

    public ProductDTO toDTO(ProductEntity productEntity){
        ProductDTO productDTO = mapper.map(productEntity, ProductDTO.class);
        productDTO.setCategoryId(productEntity.getCategory().getId());
        productDTO.setCategoryName(productEntity.getCategory().getName());
        return productDTO;
    }

}
