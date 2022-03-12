package com.example.doanthuctap.Utils;
import com.example.doanthuctap.converter.UserConverter;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    @Autowired
    private UserConverter userConverter;
    //tao bien toan cuc
    public static List<ProductEntity> cart;
    public static UserDTO userLogin;



    static {
        cart = new ArrayList<>();
    }

}
