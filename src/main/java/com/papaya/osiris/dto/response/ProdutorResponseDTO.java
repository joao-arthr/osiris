package com.papaya.osiris.dto.response;

import com.papaya.osiris.dto.AssinaturaDTO;
import com.papaya.osiris.entity.Produtor;

import java.util.List;

public record ProdutorResponseDTO(
        String id,
        String nome,
        String email,
        AssinaturaDTO assinatura,
        String imagem
) {
    public ProdutorResponseDTO(Produtor produtor) {
        this(produtor.getId().toString(),
                produtor.getNome(),
                produtor.getEmail(),
                new AssinaturaDTO(
                        produtor.getAssinatura().getDataInicio(),
                        produtor.getAssinatura().getDataTermino(),
                        produtor.getAssinatura().isAtiva()
                ),
                produtor.getImagem()
        );
    }
}
