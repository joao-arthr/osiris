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
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/predicoes")
@RequiredArgsConstructor
public class PredicaoController {
    private final PredicaoFacade predicaoFacade;
    @SneakyThrows
    @PostMapping
    public Mono<ResponseEntity<PredicaoResponseDTO>> enviarPredicao(@RequestPart("imagem") MultipartFile imagem) {
        return predicaoFacade.armazenarPredicao(imagem)
                .map(predicaoResponse -> new ResponseEntity<>(predicaoResponse, HttpStatus.OK));
    }
}
