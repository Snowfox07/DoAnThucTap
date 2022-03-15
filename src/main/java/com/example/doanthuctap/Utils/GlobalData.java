package com.example.doanthuctap.Utils;
import com.example.doanthuctap.converter.UserConverter;
import com.example.doanthuctap.dto.OrderDTO;
import com.example.doanthuctap.dto.ProductDTO;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static boolean isCheckout = true;
    public static OrderDTO orderDTO;
    public static UserDTO currentUser;
    public static List<ProductDTO> carts;

    static {
        carts = new ArrayList<>();
    }

}
