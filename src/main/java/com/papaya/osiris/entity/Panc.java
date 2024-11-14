package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.PancRequestDTO;
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
@Document(collection = "pancs")
public class Panc {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private List<String> cultivo;
    private String beneficios;
    private String imagem;
    private String locale;

    public Panc(PancRequestDTO pancRequest) {
        this.nome = pancRequest.nome();
        this.descricao = pancRequest.descricao();
        this.cultivo = pancRequest.cultivo();
        this.beneficios = pancRequest.beneficios();
        this.imagem = pancRequest.imagem();
        this.locale = pancRequest.locale();
    }
}
