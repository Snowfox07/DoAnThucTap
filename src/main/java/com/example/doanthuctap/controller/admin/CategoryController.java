package com.example.doanthuctap.controller.admin;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.entity.CategoryEntity;
import com.example.doanthuctap.service.implement.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService theCategoryService) {
        categoryService = theCategoryService;
    }

    @GetMapping("/list-category")
    public String showTable(Model theModel) {
        List<CategoryDTO> listCategory = categoryService.listCategory();
        theModel.addAttribute("listCategory", listCategory);
        return "admin/fragments/category";
    }

    @GetMapping("/delete")
    public String deleteCategoryById(@RequestParam("id") int id) {
        CategoryDTO category = categoryService.findCategoryById(id);
        category.setDelete(true);
        categoryService.save(category);
        return "redirect:/admin/category/list-category";
    }

    @GetMapping("/insert")
    public String formAddCategory(Model model) {
        CategoryDTO category = new CategoryDTO();
        model.addAttribute("category", category);
        return "admin/fragments/category-insert";
    }

    @PostMapping("/insert")
    public String addCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/fragments/category-insert";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            categoryDTO.setCreatedAt(formatter.format(date));
            categoryService.save(categoryDTO);
        }
        return "redirect:/admin/category/list-category";
    }

    @GetMapping("/update")
    public String formUpdateCategory(@RequestParam("id") int id, Model theModel){
        CategoryDTO category = categoryService.findCategoryById(id);
        theModel.addAttribute("category", category);
        return "admin/fragments/category-update";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/fragments/category-update";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            categoryDTO.setUpdatedAt(formatter.format(date));
            categoryService.save(categoryDTO);
        }
        return "redirect:/admin/category/list-category";
    }

}
