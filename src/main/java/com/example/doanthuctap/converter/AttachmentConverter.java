package com.example.doanthuctap.converter;

import com.example.doanthuctap.dto.AttachmentDTO;
import com.example.doanthuctap.dto.CategoryDTO;
import com.example.doanthuctap.entity.AttachmentEntity;
import com.example.doanthuctap.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttachmentConverter {
    @Autowired
    private final ModelMapper mapper;


    public AttachmentConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public AttachmentEntity toEntity(AttachmentDTO attachmentDTO){
        AttachmentEntity attachmentEntity = mapper.map(attachmentDTO, AttachmentEntity.class);
        return attachmentEntity;
    }

    public AttachmentDTO toDTO(AttachmentEntity attachmentEntity){
        AttachmentDTO attachmentDTO = mapper.map(attachmentEntity, AttachmentDTO.class);
        return attachmentDTO;
    }
}
