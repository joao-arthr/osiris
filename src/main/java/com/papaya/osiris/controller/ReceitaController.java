package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {
    private final FileUploadService fileUploadService;
    private final ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> criarReceita(
            @RequestBody ReceitaRequestDTO receitaRequest) {
            ReceitaResponseDTO receitaResponse = receitaService.criarReceita(receitaRequest);
            return new ResponseEntity<>(receitaResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaResponseDTO>> listarTodasReceitas() {
        List<ReceitaResponseDTO> receitaResponses = receitaService.listarTodasReceitas();
        return new ResponseEntity<>(receitaResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> buscarReceitaPorId(@PathVariable String id) {
        ReceitaResponseDTO receitaResponse = receitaService.encontrarReceitaPorId(id);
        return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> atualizarReceita(
            @PathVariable String id,
            @RequestBody ReceitaRequestDTO receitaRequest) {
        ReceitaResponseDTO receitaResponse = receitaService.substituirReceita(id, receitaRequest);
        return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable String id) {
        receitaService.deletarReceita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/imagem")
    public ResponseEntity<ReceitaResponseDTO> uploadImage(
            @PathVariable String id,
            @RequestPart("imagem") MultipartFile imagem) {
        try {
            String imgUrl = fileUploadService.uploadFile(imagem);
            ReceitaResponseDTO receitaResponse = receitaService.salvarImagem(id, imgUrl);
                return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ReceitaResponseDTO>> listarReceitasPorUsuario(@PathVariable String id){
        List<ReceitaResponseDTO> receitaResponses = receitaService.encontrarReitaPorUsuarioId(id);
        return new ResponseEntity<>(receitaResponses, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> updateReceita(@PathVariable String id, @RequestBody Map<String, Object> receitaRequest) {
        ReceitaResponseDTO receitaResponse = receitaService.atualizarReceita(id, receitaRequest);
        return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
    }
}

