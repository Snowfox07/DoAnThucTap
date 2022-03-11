package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginForm {
    @Email(regexp = "^(.+)@(.+)$",message = "Email pattern not correct")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String passWord;
}
