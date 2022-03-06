package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderDTO {
    private int id;
    private int userId;
    private String address;
    private String email;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
}
