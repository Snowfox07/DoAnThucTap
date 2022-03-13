package com.example.doanthuctap.controller.admin;

import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/user/list-user")
    public String showTable(Model theModel){
        List<UserDTO> list = userService.listUser();
        theModel.addAttribute("listuser", list);
        return "admin/fragments/user";
    }

//    @GetMapping("/user/delete")
//    public String deleteUserById(@RequestParam("id") int id) {
//        UserDTO userDTO = userService.findById(id);
//        userDTO.setDelete(true);
//        userService.save(userDTO);
//        return "redirect:/admin/user/list-user";
//    }

}
