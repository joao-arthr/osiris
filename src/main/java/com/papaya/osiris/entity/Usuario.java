package com.papaya.osiris.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
abstract public class Usuario {
    @Id
    private ObjectId _id;
    private String nome;
    private String email;
    private String senha;
}
