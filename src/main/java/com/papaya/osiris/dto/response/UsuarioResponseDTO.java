package com.papaya.osiris.dto.response;

import com.papaya.osiris.entity.Usuario;

public record UsuarioResponseDTO(
        String id,
        String nome,
        String email,
        String imagem
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getImagem()
        );
    }
}

