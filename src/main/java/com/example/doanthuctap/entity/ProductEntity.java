package com.example.doanthuctap.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "content")
    private String content;

    @Column(name = "regularprice")
    private int regularPrice;

    @Column(name = "saleprice")
    private int salePrice;

    @Column(name = "originalprice")
    private int originalPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "image")
    private String image;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "product")
    private List<AttachmentEntity> listAttachment = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
