package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.ProductConverter;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.entity.ProductEntity;
import com.example.doanthuctap.repository.ProductRepository;
import com.example.doanthuctap.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductConverter productConverter;

    @Override
    public List<ProductDTO> listProduct() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductDTO> listDTO = new ArrayList<>();
        for (ProductEntity item: list) {
            if(item.isDelete()==false){
                ProductDTO dto = productConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public List<ProductDTO> listProductByCategoryId(int id) {
        List<ProductEntity> list = productRepository.findAllByCategory_Id(id);
        List<ProductDTO> listDTO = new ArrayList<>();
        for (ProductEntity item: list) {
            if(item.isDelete()==false){
                ProductDTO dto = productConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }


    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(productConverter.toEntity(productDTO));
    }

    @Override
    public ProductDTO getProductById(int id) {
        return productConverter.toDTO(productRepository.findById(id).get());
    }
}
