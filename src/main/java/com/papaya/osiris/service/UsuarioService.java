package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequest);
    UsuarioResponseDTO substituirUsuario(String id, UsuarioRequestDTO usuarioRequest);
    void excluirUsuario(String id);
    UsuarioResponseDTO buscarUsuarioPorId(String id);
    List<UsuarioResponseDTO> listarTodosUsuarios();
    UsuarioResponseDTO salvarImagem(String id, String url);
    UsuarioResponseDTO atualizarUsuario(String id, Map<String, Object> usuarioRequest);

    UsuarioResponseDTO ativarAssinatura(String usuarioId);
}

