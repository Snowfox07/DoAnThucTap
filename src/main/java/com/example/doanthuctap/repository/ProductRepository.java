package com.example.doanthuctap.repository;

import com.example.doanthuctap.entity.CategoryEntity;
import com.example.doanthuctap.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByCategory_Id(int id);
}
