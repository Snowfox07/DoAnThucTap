package com.example.doanthuctap.repository;

import com.example.doanthuctap.entity.CategoryEntity;
import com.example.doanthuctap.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
