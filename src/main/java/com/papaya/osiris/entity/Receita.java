package com.papaya.osiris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receitas")
public class Receita {
    @Id
    @Field("_id")
    private ObjectId id;
    private String nome;
    private List<Panc> pancs;
    private List<String> ingredientes;
    private List<String> preparo;
    private String imagem;
    private ObjectId usuarioId;
}
