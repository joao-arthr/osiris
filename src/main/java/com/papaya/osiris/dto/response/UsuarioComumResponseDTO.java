package com.papaya.osiris.dto.response;

import com.papaya.osiris.entity.UsuarioComum;

import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

public record UsuarioComumResponseDTO(
        String id,
        String nome,
        String email,
        String imagem,
        List<String> pancsFavoritasId,
        List<String> receitasSalvasId
) {
    public UsuarioComumResponseDTO(UsuarioComum usuario) {
        this(usuario.getId().toString(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getImagem(),
                usuario.getPancsFavoritasId(),
                usuario.getReceitasSalvasId()
        );
    }
}

