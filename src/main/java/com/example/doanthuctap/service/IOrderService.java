package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.entity.OrderEntity;

public interface IOrderService {
    OrderEntity save(OrderDTO orderDTO);
    OrderDTO getOderById(int id);
}
