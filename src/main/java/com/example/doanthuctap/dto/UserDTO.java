package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String cmnd;
    private String sex;
    private String passWord;

}
