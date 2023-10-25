package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.PancRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "panc")
public class Panc {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String cultivo;
    private String imagem;

    public Panc(PancRequestDTO pancRequest) {
        this.nome = pancRequest.nome();
        this.descricao = pancRequest.descricao();
        this.cultivo = pancRequest.cultivo();
        this.imagem = pancRequest.imagem();
    }
}
