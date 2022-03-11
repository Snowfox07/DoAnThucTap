package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductDTO> listProduct();
    List<ProductDTO> listProductByCategoryId(int id);
    ProductEntity save(ProductDTO productDTO);
    ProductDTO getProductById(int id);
}

