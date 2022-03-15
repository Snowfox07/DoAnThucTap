package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.Utils.GlobalData;
import com.example.doanthuctap.converter.OrderConverter;
import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.OrderEntity;
import com.example.doanthuctap.entity.ProductEntity;
import com.example.doanthuctap.service.implement.OrderService;
import com.example.doanthuctap.service.implement.ProductOrderService;
import com.example.doanthuctap.service.implement.ProductService;
import com.example.doanthuctap.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/client/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public String cartGet(Model model){
        model.addAttribute("cartCount", null);
        model.addAttribute("total", null);
        model.addAttribute("cart", null);
        return "client/cart";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, Principal principal) throws Exception {
        UserDTO userDTO = userService.findByEmail(principal.getName());
        GlobalData.currentUser = userDTO;
        if(GlobalData.isCheckout==true){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setUserId(userDTO.getId());
            GlobalData.orderDTO = orderConverter.toDTO(orderService.save(orderDTO));

        }
        ProductDTO productDTO = productService.getProductById(id);
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setProduct(productDTO);
        productOrderDTO.setOrder(GlobalData.orderDTO);
        productOrderService.save(productOrderDTO);

        return "redirect:/client/shop";
    }//click add from page viewProduct

}
