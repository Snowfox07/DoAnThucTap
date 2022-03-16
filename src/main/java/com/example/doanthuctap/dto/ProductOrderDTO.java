package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductOrderDTO {
    private int id;
    private int productId;
    private int orderId;
    private int quantity;

    public void plusQuantity(){
        this.setQuantity(this.getQuantity()+1);
    }

    @Override
    public String toString() {
        return "ProductOrderDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                '}';
    }
}
