package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.PancRequestDTO;
import com.papaya.osiris.dto.response.PancResponseDTO;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.PancService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// ...

@RestController
@RequestMapping("/pancs")
@RequiredArgsConstructor
public class PancController {
    private final FileUploadService fileUploadService;
    private final PancService pancService;

    @PostMapping
    public ResponseEntity<PancResponseDTO> criarPanc(
            @RequestBody PancRequestDTO pancRequest) {
            PancResponseDTO pancResponse = pancService.criarPanc(pancRequest);
            return new ResponseEntity<>(pancResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PancResponseDTO>> listarTodasPancs() {
        List<PancResponseDTO> pancResponses = pancService.listarTodasAsPancs();
        return new ResponseEntity<>(pancResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PancResponseDTO> buscarPancPorId(@PathVariable String id) {
        PancResponseDTO pancResponse = pancService.buscarPancPorId(id);
        return new ResponseEntity<>(pancResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PancResponseDTO> atualizarPanc(
            @PathVariable String id,
            @RequestBody PancRequestDTO pancRequest) {
        PancResponseDTO pancResponse = pancService.atualizarPanc(id, pancRequest);
        return new ResponseEntity<>(pancResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPanc(@PathVariable String id) {
        pancService.excluirPancPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/imagem")
    public ResponseEntity<String> uploadImage(
            @PathVariable String id,
            @RequestPart("imagem") MultipartFile imagem) {
        try {
            String imgUrl = fileUploadService.uploadFile(imagem);
            pancService.salvarImagem(id, imgUrl);
            return ResponseEntity.ok("Imagem enviada com sucesso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

