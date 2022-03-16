package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.Utils.GlobalData;
import com.example.doanthuctap.converter.OrderConverter;
import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.dto.ProductOrderDTO;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.service.implement.OrderService;
import com.example.doanthuctap.service.implement.ProductOrderService;
import com.example.doanthuctap.service.implement.ProductService;
import com.example.doanthuctap.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/client/cart")
public class CartController {

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String cartGet(Model model) {
        model.addAttribute("cartCount", null);
        model.addAttribute("total", null);
        model.addAttribute("cart", GlobalData.carts);
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
            GlobalData.isCheckout=false;
        }
        ProductOrderDTO productOrderDTO = getProduct(id, GlobalData.orderDTO.getId());
        if(productOrderDTO!=null){
            productOrderDTO.plusQuantity();
            productOrderService.save(productOrderDTO);
        }else {
            productOrderDTO = new ProductOrderDTO();
            productOrderDTO.setQuantity(1);
            ProductDTO productDTO = productService.getProductById(id);
            GlobalData.carts.add(productDTO);
            productOrderDTO.setProductId(productDTO.getId());
            productOrderDTO.setOrderId(GlobalData.orderDTO.getId());
            productOrderService.save(productOrderDTO);
        }

        return "redirect:/client/shop";
    }//click add from page viewProduct

    public ProductOrderDTO getProduct(int productId, int orderId){
        ProductOrderDTO productOrderDTO = productOrderService.getOrderByProductIdAndOrderId(productId,orderId);
        return productOrderDTO;
    }

    public boolean productIdIsExist(int id){
        return productOrderService.findByProductId(id);
    }

}
