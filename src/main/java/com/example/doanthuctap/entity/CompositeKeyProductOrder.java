package com.example.doanthuctap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositeKeyProductOrder implements Serializable {
    @Column(name = "product_id")
    int productId;

    @Column(name = "order_id")
    int orderId;
}
