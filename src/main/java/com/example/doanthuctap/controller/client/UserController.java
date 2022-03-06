package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "admin/forgot-password";
    }

    @GetMapping("/register")
    public String register(Model theModel) {
        UserDTO userDTO = new UserDTO();
        theModel.addAttribute("user", userDTO);
        return "admin/register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid  @ModelAttribute("user") UserDTO user, Errors errors){
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/register";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            userService.saveUser(user);
        }
        return "redirect:/user/login";
    }



}
