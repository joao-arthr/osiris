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
    private final FileUploadService fIleUploadService;
    private final ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> criarReceita(
            @RequestBody ReceitaRequestDTO receitaRequest,
            @RequestParam("imagem")MultipartFile multipartFile) {
        try {
            String imgUrl = fIleUploadService.uploadFile(multipartFile);
            ReceitaResponseDTO receitaResponse = receitaService.criarReceita(receitaRequest, imgUrl);
            return new ResponseEntity<>(receitaResponse, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            @RequestParam("imagem") MultipartFile multipartFile) {

        if(fIleUploadService.isMultipartFileEmpty(multipartFile)){
            ReceitaResponseDTO receitaResponse = receitaService.atualizarReceita(id, receitaRequest, receitaRequest.imagem());
            return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
        }
        try {
            String imgUrl = fIleUploadService.uploadFile(multipartFile);
            ReceitaResponseDTO receitaResponse = receitaService.atualizarReceita(id, receitaRequest, imgUrl);
            return new ResponseEntity<>(receitaResponse, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable String id) {
        receitaService.deletarReceita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

