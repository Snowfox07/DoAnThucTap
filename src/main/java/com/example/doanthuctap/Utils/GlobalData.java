package com.example.doanthuctap.Utils;
import com.example.doanthuctap.converter.UserConverter;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    //tao bien toan cuc
    public static List<ProductEntity> cart;
    public static boolean isCheckout = true;
    public static int idOrder;
    public static UserDTO currentUser;

    static {
        cart = new ArrayList<>();
    }

}
