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
    private int id;
    @NotBlank(message = "User name cannot be blank")
    private String name;
    @Email(regexp = "^(.+)@(.+)$",message = "Email pattern not correct")
    private String email;
    @Size(min = 9, max = 12, message = "ID pattern not correct")
    private String cmnd;
    private String sex;
    @NotBlank(message = "Password cannot be blank")
    private String passWord;
    private String createdAt;
    private String updatedAt;
    private boolean isDelete;
    private String role;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
