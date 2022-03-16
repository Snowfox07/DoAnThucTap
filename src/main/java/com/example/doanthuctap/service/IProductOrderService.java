package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.ProductOrderEntity;

import java.util.List;

public interface IProductOrderService {
    ProductOrderEntity save(ProductOrderDTO productOrderDTO);
    ProductOrderDTO getOrderByProductIdAndOrderId(int productId, int orderId);
    boolean findByProductId(int productId);
    List<ProductOrderDTO> findAll();
}
