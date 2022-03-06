package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class AttachmentDTO {
    private int id;
    private String type;
    private String mime;
    private String path;
    private Date createdAt;
    private Date updatedAt;
}
