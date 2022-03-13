package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.ProductOrderConverter;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.ProductOrderEntity;
import com.example.doanthuctap.repository.ProductOrderRepository;
import com.example.doanthuctap.service.IProductOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductOrderService implements IProductOrderService {

    @Autowired
    private static ProductOrderConverter productOrderConverter;

    @Autowired
    private static ProductOrderRepository productOrderRepository;

    @Override
    public ProductOrderEntity save(ProductOrderDTO productOrderDTO) {
        return productOrderRepository.save(productOrderConverter.toEntity(productOrderDTO));
    }
}
