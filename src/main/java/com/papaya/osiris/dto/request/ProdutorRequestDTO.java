package com.papaya.osiris.dto.request;

import com.papaya.osiris.dto.AssinaturaDTO;

import java.util.List;
public record ProdutorRequestDTO(
        String nome,
        String email,
        String senha,
        String cnpj,
        List<String> celular,
        String endereco,
        AssinaturaDTO assinatura,
        String imagem
) {}

