package com.papaya.osiris.dto.request;

import java.util.List;

public record UsuarioComumRequestDTO(
        String nome,
        String email,
        String senha,
        String imagem,
        List<String> pancsFavoritasId,
        List<String> receitasSalvasId
) {}
