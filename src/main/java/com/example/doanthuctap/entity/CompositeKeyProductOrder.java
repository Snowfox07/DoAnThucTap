package com.example.doanthuctap.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositeKeyProductOrder implements Serializable {
    @Column(name = "product_id")
    int productId;

    @Column(name = "order_id")
    int orderId;
}
