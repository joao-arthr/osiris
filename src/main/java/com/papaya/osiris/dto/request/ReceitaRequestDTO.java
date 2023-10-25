package com.papaya.osiris.dto.request;

import com.papaya.osiris.entity.Panc;

import java.util.List;

public record ReceitaRequestDTO(
        String nome,
        List<Panc> pancs,
        List<String> ingredientes,
        List<String> preparo,
        String imagem,
        String usuarioId
) {}

