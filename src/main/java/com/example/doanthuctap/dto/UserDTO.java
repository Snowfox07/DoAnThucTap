package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {
    @NotBlank(message = "User name cannot be blank")
    private String name;
    @Email(regexp = "^(.+)@(.+)$",message = "Email pattern not correct")
    private String email;
    @Size(min = 9, max = 12, message = "ID pattern not correct")
    private String cmnd;
    private String sex;
    private String passWord;
    private String createdAt;
    private String updatedAt;
}
