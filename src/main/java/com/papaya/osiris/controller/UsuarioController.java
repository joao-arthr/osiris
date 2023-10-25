package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioResponseDTO usuarioResponse = usuarioService.criarUsuario(usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodosUsuarios() {
        List<UsuarioResponseDTO> usuarioResponses = usuarioService.listarTodosUsuarios();
        return new ResponseEntity<>(usuarioResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable String id) {
        UsuarioResponseDTO usuarioResponse = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable String id, @RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioResponseDTO usuarioResponse = usuarioService.atualizarUsuario(id, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable String id) {
        usuarioService.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

