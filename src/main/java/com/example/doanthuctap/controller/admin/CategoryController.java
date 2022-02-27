package com.example.doanthuctap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/list-category")
    public String showTable(){
        return "admin/fragments/category";
    }
}
