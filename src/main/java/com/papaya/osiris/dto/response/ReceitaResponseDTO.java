package com.papaya.osiris.dto.response;


import com.papaya.osiris.entity.Panc;
import com.papaya.osiris.entity.Receita;

import java.util.List;

public record ReceitaResponseDTO(
        String id,
        String nome,
        String descricao,
        List<String> pancs,
        List<String> ingredientes,
        List<String> preparo,
        String imagem,
        String usuarioId,
        String locale
) {
    public ReceitaResponseDTO(Receita receita) {
        this(receita.getId(),
                receita.getNome(),
                receita.getDescricao(),
                receita.getPancs(),
                receita.getIngredientes(),
                receita.getPreparo(),
                receita.getImagem(),
                receita.getUsuarioId(),
                receita.getLocale()
        );
    }

    public static ReceitaResponseDTO fromReceita(Receita receita) {
        return new ReceitaResponseDTO(
                receita.getId(),
                receita.getNome(),
                receita.getDescricao(),
                receita.getPancs(),
                receita.getIngredientes(),
                receita.getPreparo(),
                receita.getImagem(),
                receita.getUsuarioId(),
                receita.getLocale()
        );
    }
}

