package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.UsuarioComumRequestDTO;
import com.papaya.osiris.dto.response.UsuarioComumResponseDTO;

import java.util.List;

public interface UsuarioComumService {
    List<UsuarioComumResponseDTO> listarTodosUsuariosComuns();
    UsuarioComumResponseDTO buscarUsuarioComumPorId(String id);
    UsuarioComumResponseDTO criarUsuarioComum(UsuarioComumRequestDTO usuarioComumRequest);
    UsuarioComumResponseDTO atualizarUsuarioComum(String id, UsuarioComumRequestDTO usuarioComumRequest);
    void excluirUsuarioComum(String id);
}

