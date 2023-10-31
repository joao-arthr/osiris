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
            @RequestBody PancRequestDTO pancRequest,
            @RequestParam("imagem")MultipartFile multipartFile) {
        try {
            String url = fileUploadService.uploadFile(multipartFile);
            PancResponseDTO pancResponse = pancService.criarPanc(pancRequest, url);
            return new ResponseEntity<>(pancResponse, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            @RequestBody PancRequestDTO pancRequest,
            @RequestParam("imagem") MultipartFile multipartFile) {

        if (fileUploadService.isMultipartFileEmpty(multipartFile)) {
            PancResponseDTO pancResponse = pancService.atualizarPanc(id, pancRequest, pancRequest.imagem());
            return new ResponseEntity<>(pancResponse, HttpStatus.OK);
        }
        try {
            String imgUrl = fileUploadService.uploadFile(multipartFile);
            PancResponseDTO pancResponse = pancService.atualizarPanc(id, pancRequest, imgUrl);
            return new ResponseEntity<>(pancResponse, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPanc(@PathVariable String id) {
        pancService.excluirPancPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

