package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.service.implement.CategoryService;
import com.example.doanthuctap.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ShopController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("cartCount", 5);
        model.addAttribute("categories", categoryService.listCategory());
        model.addAttribute("products", productService.listProduct());
        return "client/shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCat(@PathVariable int id, Model model){
        model.addAttribute("categories", categoryService.listCategory());
        model.addAttribute("products", productService.listProductByCategoryId(id));
        return "client/shop";
    } //view Products By Category


    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "client/viewProduct";
    } //view product Details
}
