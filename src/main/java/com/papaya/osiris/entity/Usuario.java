package com.papaya.osiris.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
abstract public class Usuario {
    @Id
    private ObjectId id;
    private String email;
    private String senha;
}
