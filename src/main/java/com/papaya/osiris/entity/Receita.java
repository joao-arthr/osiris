package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.ReceitaRequestDTO;
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
    private String id;
    private String nome;
    private List<String> pancs;
    private List<String> ingredientes;
    private List<String> preparo;
    private String imagem;
    private String usuarioId;

    public Receita(ReceitaRequestDTO receitaRequest) {
        this.nome = receitaRequest.nome();
        this.pancs = receitaRequest.pancs();
        this.ingredientes = receitaRequest.ingredientes();
        this.preparo = receitaRequest.preparo();
        this.imagem = receitaRequest.imagem();
        this.usuarioId = receitaRequest.usuarioId();
    }
}
