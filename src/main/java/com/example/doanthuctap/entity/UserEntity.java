package com.example.doanthuctap.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@RequiredArgsConstructor
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "password")
    private String passWord;

    @Column(name = "sex")
    private String sex;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "isdelete")
    private boolean isDelete = Boolean.FALSE;

    @Column(name = "role")
    private String role;

    public UserEntity(UserEntity user) {
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.cmnd = user.cmnd;
        this.passWord = user.passWord;
        this.sex = user.sex;
        this.createdAt = user.createdAt;
        this.updatedAt = user.updatedAt;
        this.isDelete = user.isDelete;
        this.role = user.role;
    }
}
