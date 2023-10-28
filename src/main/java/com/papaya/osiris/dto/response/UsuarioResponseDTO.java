package com.papaya.osiris.dto.response;

import com.papaya.osiris.dto.AssinaturaDTO;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.enums.Perfil;

import java.util.List;

public record UsuarioResponseDTO(
        String id,
        String nome,
        String email,
        List<String> pancsFavoritasId,
        List<String> receitasSalvasId,
        Perfil perfil,
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
                usuario.getPerfil(),
                new AssinaturaDTO(usuario.getAssinatura()),
                usuario.getImagem()
        );
    }
}

