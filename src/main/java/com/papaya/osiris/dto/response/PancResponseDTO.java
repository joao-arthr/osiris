package com.papaya.osiris.dto.response;

import com.papaya.osiris.entity.Panc;

import java.util.List;

public record PancResponseDTO(
        String id,
        String nome,
        String descricao,
        List<String> cultivo,
        String beneficios,
        String imagem
) {
    public PancResponseDTO(Panc panc) {
        this(panc.getId(),
                panc.getNome(),
                panc.getDescricao(),
                panc.getCultivo(),
                panc.getBeneficios(),
                panc.getImagem()
        );
    }
}

