package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.CategoryConverter;
import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.entity.CategoryEntity;
import com.example.doanthuctap.repository.CategoryRepository;
import com.example.doanthuctap.service.ICategoryService;
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
public class CategoryService implements ICategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryConverter categoryConverter;


    @Override
    public CategoryEntity save(CategoryDTO category) {
        return categoryRepository.save(categoryConverter.toEntity(category));
    }

    @Override
    public List<CategoryDTO> listCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();
        for (CategoryEntity item: list) {
            CategoryDTO dto = categoryConverter.toDTO(item);
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
