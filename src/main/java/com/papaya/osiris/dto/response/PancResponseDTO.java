package com.papaya.osiris.dto.response;

import com.papaya.osiris.entity.Panc;

public record PancResponseDTO(
        String id,
        String nome,
        String descricao,
        String cultivo,
        String imagem
) {
    public PancResponseDTO(Panc panc) {
        this(panc.getId().toString(),
                panc.getNome(),
                panc.getDescricao(),
                panc.getCultivo(),
                panc.getImagem()
        );
    }
}

