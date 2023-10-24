package com.papaya.osiris.dto.request;

import org.bson.types.ObjectId;

import java.util.List;

public record UsuarioComumRequestDTO(
        String nome,
        String email,
        String senha,
        String imagem,
        List<ObjectId> pancsFavoritasId,
        List<ObjectId> receitasSalvasId
) {}
