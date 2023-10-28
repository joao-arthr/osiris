package com.papaya.osiris.dto.request;

import com.papaya.osiris.dto.AssinaturaDTO;
import com.papaya.osiris.enums.Perfil;

import java.util.List;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        List<String> pancsFavoritasId,
        List<String> receitasSalvasId,
        Perfil perfil,
        AssinaturaDTO assinatura,
        String imagem
) {}

