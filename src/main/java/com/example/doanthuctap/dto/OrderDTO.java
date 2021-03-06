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
    private String phone;
    private String createdAt;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
