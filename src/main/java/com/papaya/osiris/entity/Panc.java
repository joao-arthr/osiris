package com.papaya.osiris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "panc")
public class Panc {
    @Id
    private ObjectId id;
    private String nome;
    private String descricao;
    private String cultivo;
    private String imagem;
}
