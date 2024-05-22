package com.papaya.osiris.controller;

import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.facade.PredicaoFacade;
import com.papaya.osiris.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/predicoes")
@RequiredArgsConstructor
public class PredicaoController {
    private final PredicaoFacade predicaoFacade;
    @SneakyThrows
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> enviarPredicao(@RequestPart("imagem") MultipartFile imagem) {
        predicaoFacade.armazenarPredicao(imagem);
        return null;
    }
}
