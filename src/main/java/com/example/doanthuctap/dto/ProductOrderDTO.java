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
    private ProductDTO product;
    private OrderDTO order;
    private int quantity;

    @Override
    public String toString() {
        return "ProductOrderDTO{" +
                "product=" + product.toString() +
                ", order=" + order.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
