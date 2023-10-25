package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.ProdutorRequestDTO;
import com.papaya.osiris.dto.response.ProdutorResponseDTO;
import com.papaya.osiris.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/produtores")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping
    public ResponseEntity<ProdutorResponseDTO> criarProdutor(@RequestBody ProdutorRequestDTO produtorRequest) {
        ProdutorResponseDTO produtorResponse = produtorService.criarProdutor(produtorRequest);
        return new ResponseEntity<>(produtorResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutorResponseDTO>> listarTodosProdutores() {
        List<ProdutorResponseDTO> produtorResponses = produtorService.listarTodosProdutores();
        return new ResponseEntity<>(produtorResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutorResponseDTO> buscarProdutorPorId(@PathVariable String id) {
        ProdutorResponseDTO produtorResponse = produtorService.buscarProdutorPorId(id);
        return new ResponseEntity<>(produtorResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutorResponseDTO> atualizarProdutor(@PathVariable String id, @RequestBody ProdutorRequestDTO produtorRequest) {
        ProdutorResponseDTO produtorResponse = produtorService.atualizarProdutor(id, produtorRequest);
        return new ResponseEntity<>(produtorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProdutor(@PathVariable String id) {
        produtorService.excluirProdutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
