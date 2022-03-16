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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductOrderService implements IProductOrderService {

    @Autowired
    private final ProductOrderRepository productOrderRepository;

    @Autowired
    private final ProductOrderConverter productOrderConverter;


    @Override
    public ProductOrderEntity save(ProductOrderDTO productOrderDTO) {
        ProductOrderEntity productOrderEntity = new ProductOrderEntity();
        productOrderEntity.setId(productOrderDTO.getId());
        productOrderEntity.setProductId(productOrderDTO.getProductId());
        productOrderEntity.setOrderId(productOrderDTO.getOrderId());
        productOrderEntity.setQuantity(productOrderDTO.getQuantity());
        return productOrderRepository.save(productOrderEntity);
    }

    @Override
    public ProductOrderDTO getOrderByProductIdAndOrderId(int productId, int orderId) {
        ProductOrderEntity productOrderEntity = productOrderRepository.findOrderEntityByProductIdAndOrderId(productId, orderId);
        if(productOrderEntity==null){
            return null;
        }
        return productOrderConverter.toDTO(productOrderRepository.findOrderEntityByProductIdAndOrderId(productId, orderId));
    }

    @Override
    public boolean findByProductId(int productId) {
        if(productOrderRepository.findOrderEntityByProductId(productId)==null){
            return false;

        }else return true;
    }

    @Override
    public List<ProductOrderDTO> findAll() {
        List<ProductOrderEntity> list = productOrderRepository.findAll();
        List<ProductOrderDTO> listDTO = new ArrayList<>();
        for (ProductOrderEntity item: list) {
            ProductOrderDTO dto = productOrderConverter.toDTO(item);
            listDTO.add(dto);
        }
        return listDTO;
    }
}