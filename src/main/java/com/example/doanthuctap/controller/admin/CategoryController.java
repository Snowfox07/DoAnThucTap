package com.example.doanthuctap.controller.admin;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.service.implement.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService theCategoryService) {
        categoryService = theCategoryService;
    }

    @GetMapping("/list-category")
    public String showTable(Model theModel){
        List<CategoryDTO> listCategory = categoryService.listCategory();
        theModel.addAttribute("listCategory", listCategory);
        return "admin/fragments/category";
    }

    @DeleteMapping("/delete")
    public String deleteCategoryById(@RequestParam("id") Long id){
        categoryService.delete(id);
        return "redirect:/category/list-category";
    }

    @GetMapping("/insert")
    public String addCategory(){
        return "admin/fragments/category-insert";
    }
}
