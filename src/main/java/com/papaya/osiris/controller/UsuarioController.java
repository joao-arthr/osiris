package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final FileUploadService fileUploadService;

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
        UsuarioResponseDTO usuarioResponse = usuarioService.substituirUsuario(id, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable String id) {
        usuarioService.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/imagem")
    public ResponseEntity<UsuarioResponseDTO> uploadImage(
            @PathVariable String id,
            @RequestPart("imagem") MultipartFile imagem) {
        try {
            String imgUrl = fileUploadService.uploadFile(imagem);
            UsuarioResponseDTO usuarioResponse = usuarioService.salvarImagem(id, imgUrl);
            return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable String id, @RequestBody Map<String, Object> usuarioRequest) {
        UsuarioResponseDTO usuarioResponse = usuarioService.atualizarUsuario(id, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @PatchMapping("/{id}/assinatura")
    public ResponseEntity<UsuarioResponseDTO> ativarAssinatura(@PathVariable String id){
        UsuarioResponseDTO usuarioResponse = usuarioService.ativarAssinatura(id);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }
}

