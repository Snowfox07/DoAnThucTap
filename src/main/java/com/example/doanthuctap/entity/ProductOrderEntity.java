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

    @EmbeddedId()
    private CompositeKeyProductOrder id;

    @ManyToOne()
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne()
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "quantity")
    private int quantity;


    @Override
    public java.lang.String toString() {
        return "ProductOrderEntity{" +
                "id=" + id +
                ", product=" + product.toString() +
                ", order=" + order.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
