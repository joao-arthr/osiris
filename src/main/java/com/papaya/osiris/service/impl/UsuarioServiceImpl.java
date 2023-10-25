package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.exception.UsuarioNotFoundException;
import com.papaya.osiris.repository.UsuarioRepository;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequest) {
        return new UsuarioResponseDTO(usuarioRepository.save(new Usuario(usuarioRequest)));
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(String id, UsuarioRequestDTO usuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        BeanUtils.copyProperties(usuarioRequest, usuarioExistente);
        return new UsuarioResponseDTO(usuarioRepository.save(usuarioExistente));
    }

    @Override
    public void excluirUsuario(String id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        usuarioRepository.delete(usuarioExistente);
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getImagem());
    }

    @Override
    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
    }
}

