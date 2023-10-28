package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.entity.Assinatura;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.enums.Perfil;
import com.papaya.osiris.exception.EmailDuplicadoException;
import com.papaya.osiris.exception.UsuarioNotFoundException;
import com.papaya.osiris.repository.UsuarioRepository;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public boolean existeUsuarioComEmail(String email) {
        return usuarioRepository.findByEmail(email) != null;
    }
    @Override
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequest) {

        if (!existeUsuarioComEmail(usuarioRequest.email())) {
            return new UsuarioResponseDTO(usuarioRepository.save(new Usuario(
                    usuarioRequest.nome(),
                    usuarioRequest.email(),
                    new BCryptPasswordEncoder().encode(usuarioRequest.senha()),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    usuarioRequest.perfil(),
                    new Assinatura(),
                    usuarioRequest.imagem())
            ));
        }
        throw new EmailDuplicadoException();
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
        return new UsuarioResponseDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .toList();
    }
}

