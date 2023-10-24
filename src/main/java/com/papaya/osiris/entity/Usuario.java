package com.papaya.osiris.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public abstract class Usuario {
    @Id
    @Field("_id")
    private ObjectId id;
    private String nome;
    private String email;
    private String senha;
    private String imagem;
}
