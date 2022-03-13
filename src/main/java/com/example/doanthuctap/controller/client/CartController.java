package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.Utils.GlobalData;
import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.entity.ProductEntity;
import com.example.doanthuctap.service.implement.OrderService;
import com.example.doanthuctap.service.implement.ProductOrderService;
import com.example.doanthuctap.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/client/cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductOrderService productOrderService;

    @GetMapping()
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(ProductEntity::getSalePrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "client/cart";
    }//page cart

//    @GetMapping("/addToCart/{id}")
//    public String addToCart(@PathVariable int id) throws Exception {
//        if(GlobalData.isCheckout==true){
//            OrderDTO orderDTO = new OrderDTO();
//            GlobalData.isCheckout = false;
//            orderDTO.setUserId(GlobalData.currentUser.getId());
//            OrderEntity orderEntity = orderService.save(orderDTO);
//            GlobalData.idOrder = orderEntity.getId();
//
//        }
//        ProductDTO productDTO = productService.getProductById(id);
//        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
//        productOrderDTO.setProduct(productDTO);
//        productOrderDTO.setOrder(orderService.getOderById(GlobalData.idOrder));
//        productOrderDTO.setQuantity(1);
//        System.out.println(productOrderDTO.getOrder().getId()+" --- "+productOrderDTO.getProduct().getId()+" --- "+productOrderDTO.getQuantity());
//        productOrderService.save(productOrderDTO);
//        return "redirect:/shop";
//    }//click add from page viewProduct

}
