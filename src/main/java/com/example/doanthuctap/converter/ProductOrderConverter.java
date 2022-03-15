package com.example.doanthuctap.converter;

import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.entity.ProductOrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderConverter {

    @Autowired
    private final ModelMapper mapper;

    public ProductOrderConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductOrderEntity toEntity(ProductOrderDTO productOrderDTO){
        ProductOrderEntity productOrderEntity = mapper.map(productOrderDTO, ProductOrderEntity.class);
        return productOrderEntity;
    }

    public ProductOrderDTO toDTO(ProductOrderEntity productOrderEntity){
        ProductOrderDTO productOrderDTO = mapper.map(productOrderEntity, ProductOrderDTO.class);
        return productOrderDTO;
    }
}
