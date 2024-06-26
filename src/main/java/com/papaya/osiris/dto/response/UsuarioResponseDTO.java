package com.papaya.osiris.dto.response;

import com.papaya.osiris.dto.AssinaturaDTO;
import com.papaya.osiris.entity.Usuario;

import java.util.List;

public record UsuarioResponseDTO(
        String id,
        String nome,
        String email,
        List<String> pancsFavoritasId,
        List<String> receitasSalvasId,
        AssinaturaDTO assinatura,
        String imagem
        ) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPancsFavoritasId(),
                usuario.getReceitasSalvasId(),
                new AssinaturaDTO(usuario.getAssinatura()),
                usuario.getImagem()
        );
    }
}

