package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.UsuarioComumRequestDTO;
import com.papaya.osiris.dto.response.UsuarioComumResponseDTO;
import com.papaya.osiris.entity.UsuarioComum;
import com.papaya.osiris.exception.UsuarioComumNotFoundException;
import com.papaya.osiris.repository.UsuarioComumRepository;
import com.papaya.osiris.service.UsuarioComumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioComumServiceImpl implements UsuarioComumService {

    private final UsuarioComumRepository usuarioComumRepository;

    @Override
    public List<UsuarioComumResponseDTO> listarTodosUsuariosComuns() {
        List<UsuarioComum> usuariosComuns = usuarioComumRepository.findAll();
        return usuariosComuns.stream().map(UsuarioComumResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioComumResponseDTO buscarUsuarioComumPorId(String id) {
        UsuarioComum usuarioComum = usuarioComumRepository.findById(id)
                .orElseThrow(() -> new UsuarioComumNotFoundException(id));
        return new UsuarioComumResponseDTO(usuarioComum);
    }

    @Override
    public UsuarioComumResponseDTO criarUsuarioComum(UsuarioComumRequestDTO usuarioComumRequest) {
        return new UsuarioComumResponseDTO(usuarioComumRepository.save(new UsuarioComum(usuarioComumRequest)));
    }

    @Override
    public UsuarioComumResponseDTO atualizarUsuarioComum(String id, UsuarioComumRequestDTO usuarioComumRequest) {
        UsuarioComum usuarioComumExistente = usuarioComumRepository.findById(id)
                .orElseThrow(() -> new UsuarioComumNotFoundException(id));
        BeanUtils.copyProperties(usuarioComumRequest, usuarioComumExistente);
        return new UsuarioComumResponseDTO(usuarioComumRepository.save(usuarioComumExistente));
    }

    @Override
    public void excluirUsuarioComum(String id) {
        usuarioComumRepository.deleteById(id);
    }
}
