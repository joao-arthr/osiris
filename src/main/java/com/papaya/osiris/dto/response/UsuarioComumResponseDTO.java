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
    public static UsuarioComumResponseDTO create(
            String id,
            String nome,
            String email,
            String imagem,
            List<String> pancsFavoritasId,
            List<String> receitasSalvasId
    ) {
        return new UsuarioComumResponseDTO(id, nome, email, imagem, pancsFavoritasId, receitasSalvasId);
    }

    public static UsuarioComumResponseDTO fromUsuarioComum(UsuarioComum usuario) {
        return new UsuarioComumResponseDTO(
                usuario.getId().toString(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getImagem(),
                usuario.getPancsFavoritasId().stream()
                        .map(ObjectId::toString)
                        .collect(Collectors.toList()),
                usuario.getReceitasSalvasId().stream()
                        .map(ObjectId::toString)
                        .collect(Collectors.toList())
        );
    }
}

