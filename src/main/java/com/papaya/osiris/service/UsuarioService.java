package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequest);
    UsuarioResponseDTO atualizarUsuario(String id, UsuarioRequestDTO usuarioRequest);
    void excluirUsuario(String id);
    UsuarioResponseDTO buscarUsuarioPorId(String id);
    List<UsuarioResponseDTO> listarTodosUsuarios();
}

