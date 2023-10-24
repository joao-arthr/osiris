package com.papaya.osiris.dto.response;

import com.papaya.osiris.dto.AssinaturaDTO;

import java.util.List;

public record ProdutorResponseDTO(
        String id,
        String nome,
        String email,
        String cnpj,
        List<String> celular,
        String endereco,
        AssinaturaDTO assinatura,
        String imagem
) {}
