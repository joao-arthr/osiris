package com.papaya.osiris.dto.request;

import java.util.List;

public record PancRequestDTO(
        String nome,
        String descricao,
        List<String> cultivo,
        String beneficios,
        String imagem
) {}

