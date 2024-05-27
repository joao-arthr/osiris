package com.papaya.osiris.service.impl;
import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.entity.Assinatura;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.exception.EmailDuplicadoException;
import com.papaya.osiris.exception.PancNotFoundException;
import com.papaya.osiris.exception.UsuarioNotFoundException;
import com.papaya.osiris.repository.UsuarioRepository;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
                    new Assinatura(),
                    usuarioRequest.imagem())
            ));
        }
        throw new EmailDuplicadoException();
    }

    @Override
    public UsuarioResponseDTO substituirUsuario(String id, UsuarioRequestDTO usuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        BeanUtils.copyProperties(usuarioRequest, usuarioExistente);
        usuarioExistente.setAssinatura(new Assinatura(false,null,null));
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

    @Override
    public UsuarioResponseDTO salvarImagem(String id, String url){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new PancNotFoundException(id));
        usuarioExistente.setImagem(url);
        return new UsuarioResponseDTO(usuarioRepository.save(usuarioExistente));
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(String id, Map<String, Object> usuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        Set<String> camposNaoEditaveis = Set.of("id","assinatura", "imagem");
        usuarioRequest.forEach((key,value) ->{
             if (!camposNaoEditaveis.contains(key)) {
                try {
                    Field field = Usuario.class.getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(usuarioExistente, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new IllegalArgumentException("Atributo " + key + " não é atualizável.", e);
                }
            }
        });
        return new UsuarioResponseDTO(usuarioRepository.save(usuarioExistente));
    }

    @Override
    public UsuarioResponseDTO ativarAssinatura(String usuarioId) {
        Usuario usuarioExistente = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException(usuarioId));
        Assinatura assinatura = new Assinatura(true, LocalDate.now(), LocalDate.now().plusDays(30));
        usuarioExistente.setAssinatura(assinatura);
        return new UsuarioResponseDTO(usuarioRepository.save(usuarioExistente));
    }


    @Scheduled(cron = "0 0 0 * * ?")
    public void desativarAssinaturasExpiradas() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> usuariosParaAtualizar = usuarios.stream()
                .filter(usuario -> {
                    Assinatura assinatura = usuario.getAssinatura();
                    return assinatura != null && assinatura.isAtiva() && assinatura.getDataTermino().isBefore(LocalDate.now());
                })
                .peek(usuario -> usuario.getAssinatura().setAtiva(false))
                .toList();
        usuarioRepository.saveAll(usuariosParaAtualizar);
    }

}

