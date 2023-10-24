package com.papaya.osiris.dto.response;

import com.papaya.osiris.dto.AssinaturaDTO;

import java.util.List;

public record ProdutorResponseDTO(
        String id,
        String nome,
        String email,
        AssinaturaDTO assinatura,
        String imagem
) {}
