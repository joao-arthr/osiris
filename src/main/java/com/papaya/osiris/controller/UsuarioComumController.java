package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.UsuarioComumRequestDTO;
import com.papaya.osiris.dto.response.UsuarioComumResponseDTO;
import com.papaya.osiris.service.UsuarioComumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios-comuns")
@RequiredArgsConstructor
public class UsuarioComumController {

    private final UsuarioComumService usuarioComumService;

    @PostMapping
    public ResponseEntity<UsuarioComumResponseDTO> criarUsuarioComum(@RequestBody UsuarioComumRequestDTO usuarioComumRequest) {
        UsuarioComumResponseDTO usuarioComumResponse = usuarioComumService.criarUsuarioComum(usuarioComumRequest);
        return new ResponseEntity<>(usuarioComumResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioComumResponseDTO>> listarTodosUsuariosComuns() {
        List<UsuarioComumResponseDTO> usuarioComumResponses = usuarioComumService.listarTodosUsuariosComuns();
        return new ResponseEntity<>(usuarioComumResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioComumResponseDTO> buscarUsuarioComumPorId(@PathVariable String id) {
        UsuarioComumResponseDTO usuarioComumResponse = usuarioComumService.buscarUsuarioComumPorId(id);
        return new ResponseEntity<>(usuarioComumResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioComumResponseDTO> atualizarUsuarioComum(
            @PathVariable String id,
            @RequestBody UsuarioComumRequestDTO usuarioComumRequest
    ) {
        UsuarioComumResponseDTO usuarioComumResponse = usuarioComumService.atualizarUsuarioComum(id, usuarioComumRequest);
        return new ResponseEntity<>(usuarioComumResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuarioComum(@PathVariable String id) {
        usuarioComumService.excluirUsuarioComum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

