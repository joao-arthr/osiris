package com.papaya.osiris.dto.request;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        String imagem
) {}

