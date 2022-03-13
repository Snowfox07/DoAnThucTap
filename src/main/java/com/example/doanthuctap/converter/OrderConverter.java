package com.example.doanthuctap.converter;

import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private final ModelMapper mapper;

    public OrderConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public OrderEntity toEntity(OrderDTO orderDTO){
        OrderEntity orderEntity = mapper.map(orderDTO, OrderEntity.class);
        return orderEntity;
    }

    public OrderDTO toDTO(OrderEntity orderEntity){
        OrderDTO orderDTO = mapper.map(orderEntity, OrderDTO.class);
        return orderDTO;
    }
}
