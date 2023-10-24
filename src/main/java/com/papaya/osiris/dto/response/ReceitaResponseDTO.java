package com.papaya.osiris.dto.response;


import com.papaya.osiris.entity.Panc;
import com.papaya.osiris.entity.Receita;

import java.util.List;

public record ReceitaResponseDTO(
        String id,
        String nome,
        List<Panc> pancs,
        List<String> ingredientes,
        List<String> preparo,
        Integer likes,
        String imagem,
        String usuarioId
) {
    public ReceitaResponseDTO(Receita receita) {
        this(receita.getId().toString(),
                receita.getNome(),
                receita.getPancs(),
                receita.getIngredientes(),
                receita.getPreparo(),
                receita.getLikes(),
                receita.getImagem(),
                receita.getUsuarioId().toString()
        );
    }
}

