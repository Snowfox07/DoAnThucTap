package com.example.doanthuctap.controller.client;

import com.example.doanthuctap.Utils.GlobalData;
import com.example.doanthuctap.dto.LoginForm;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;
import com.example.doanthuctap.repository.UserRepository;
import com.example.doanthuctap.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/redirect")
    public String redirect(Principal user){
        UserDTO userDTO = userService.findByEmail(user.getName());
        GlobalData.currentUser = userDTO;
        if(userDTO.getRole().equals("ADMIN")){
            return "redirect:/admin/index";
        } else {
            return "redirect:/client/index";
        }
    }

//    @PostMapping("/login")
//    public String loginUser(@Valid @ModelAttribute("userlogin") LoginForm userForm, Errors errors, Model theModel){
//        if (null != errors && errors.getErrorCount() > 0) {
//            return "admin/login";
//        }else {
//            System.out.println("anything");
//            List<UserDTO> userDTOList = userService.listUserAll();
//            UserDTO userDTO = new UserDTO();
//            boolean isTrue=false;
//            for (UserDTO item : userDTOList) {
//                if(item.getEmail().equals(userForm.getEmail())){
//                    isTrue = true;
//                    userDTO = item;
//                    break;
//                }
//            }
//            if(isTrue){
//                if(bCryptPasswordEncoder.matches(userForm.getPassWord(),userDTO.getPassWord())){
//                    if(userDTO.getRole().equals("ADMIN")){
//                        return "redirect:/admin/index";
//                    }else {
//                        return "redirect:/client/index";
//                    }
//
//                }else {
//                    theModel.addAttribute("error",true);
//                    return "admin/login";
//                }
//
//            }else {
//                theModel.addAttribute("error","email or password is invalid");
//                return "admin/login";
//            }
//        }
//    }

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

    @PostMapping("/register")
    public String saveUser(@Valid  @ModelAttribute("user") UserDTO user, Errors errors, Model theModel) throws Exception{
        if (null != errors && errors.getErrorCount() > 0) {
            return "admin/register";
        } else {
            List<UserDTO> list = userService.listUserAll();
            boolean isTrue=false;
            for (UserDTO item : list) {
                if(item.getEmail().equals(user.getEmail())){
                    isTrue = true;
                    break;
                }
            }
            if(isTrue){
                theModel.addAttribute("error", "Email is already has an account");
                return "admin/register";
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            user.setCreatedAt(formatter.format(date));
            user.setRole("USER");
            userService.save(user);
        }
        return "redirect:/login";
    }

//    @GetMapping("/logout")
//    public String logout(Principal principal){
//        UserDTO userDTO = userService.findByEmail(principal.getName());
//        if(userDTO.getRole().equals("ADMIN")){
//            return "redirect:/login";
//        }else {
//
//        }
//    }

}
