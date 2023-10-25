package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.ProdutorRequestDTO;
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
    private Assinatura assinatura;

    public Produtor(ProdutorRequestDTO produtorRequest) {
        super(
                produtorRequest.nome(),
                produtorRequest.email(),
                produtorRequest.senha(),
                produtorRequest.imagem()
        );
        this.assinatura = new Assinatura(produtorRequest.assinatura());
    }
}
