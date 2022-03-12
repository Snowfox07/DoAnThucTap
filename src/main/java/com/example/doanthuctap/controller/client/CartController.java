package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.Utils.GlobalData;
import com.example.doanthuctap.entity.ProductEntity;
import com.example.doanthuctap.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/cart")
public class CartController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(ProductEntity::getSalePrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }//page cart
}
