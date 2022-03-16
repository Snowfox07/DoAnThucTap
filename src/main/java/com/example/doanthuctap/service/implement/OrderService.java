package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.OrderConverter;
import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.repository.OrderRepository;
import com.example.doanthuctap.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final OrderConverter orderConverter;

    @Override
    public OrderEntity save(OrderDTO orderDTO) {
        return orderRepository.save(orderConverter.toEntity(orderDTO));
    }

    @Override
    public OrderDTO getOderById(int id) {
        return orderConverter.toDTO(orderRepository.findById(id).get());
    }

}
