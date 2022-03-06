package com.example.doanthuctap.dto;

import com.example.doanthuctap.entity.CompositeKeyProductOrder;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.entity.ProductEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductOrderDTO {
    private CompositeKeyProductOrder id;
    private ProductEntity product;
    private OrderEntity order;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;

}
