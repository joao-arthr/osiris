package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
            @RequestBody ReceitaRequestDTO receitaRequest,
            @RequestPart("imagem") MultipartFile multipartFile) {
        ReceitaResponseDTO receitaResponse = receitaService.atualizarReceita(id, receitaRequest);
        return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable String id) {
        receitaService.deletarReceita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/imagem")
    public ResponseEntity<String> uploadImage(
            @PathVariable String id,
            @RequestPart("imagem") MultipartFile imagem) {
        try {
            String imgUrl = fileUploadService.uploadFile(imagem);
            receitaService.salvarImagem(id, imgUrl);
            return ResponseEntity.ok("Imagem enviada com sucesso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ReceitaResponseDTO>> listarReceitasPorUsuario(@PathVariable String id){
        List<ReceitaResponseDTO> receitaResponses = receitaService.encontrarReitaPorUsuarioId(id);
        return new ResponseEntity<>(receitaResponses, HttpStatus.OK);
    }
}

