package com.papaya.osiris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "")
public class Produtor extends Usuario {
    private String nome;
    private String cnpj;
    private List<String> celular;
    private String endereco;
    private Assinatura assinatura;
    private String imagem;

}
