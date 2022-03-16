package com.example.doanthuctap.repository;

import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.entity.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Integer> {
    ProductOrderEntity findOrderEntityByProductIdAndOrderId(int productId, int orderId);
    ProductOrderEntity findOrderEntityByProductId(int productId);
}
