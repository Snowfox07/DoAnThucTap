package com.example.doanthuctap.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="product_order")
public class ProductOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private int productId;


    @Column(name = "order_id")
    private int orderId;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
        return "ProductOrderEntity{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                '}';
    }
}
