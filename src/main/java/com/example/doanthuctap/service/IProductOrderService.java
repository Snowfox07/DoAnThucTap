package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.ProductOrderEntity;

public interface IProductOrderService {
    ProductOrderEntity save(ProductOrderDTO productOrderDTO);
}
