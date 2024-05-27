package com.papaya.osiris.controller;

import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.facade.PredicaoFacade;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.PredicaoService;
import com.papaya.osiris.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/predicoes")
@RequiredArgsConstructor
public class PredicaoController {
    private final PredicaoService predicaoService;
    private final PredicaoFacade predicaoFacade;
    private final TokenService tokenService;
    @SneakyThrows
    @PostMapping
    public Mono<ResponseEntity<PredicaoResponseDTO>> enviarPredicao(@RequestPart("imagem") MultipartFile imagem, HttpServletRequest request) {
        String usuarioId = tokenService.extrirUsuarioId(tokenService.recuperarToken(request));
        return predicaoFacade.armazenarPredicao(imagem, usuarioId)
                .map(predicaoResponse -> new ResponseEntity<>(predicaoResponse, HttpStatus.CREATED));
    }

    @GetMapping("usuario/{idUsuario}")
    public ResponseEntity<List<PredicaoResponseDTO>> buscarPredicoesPorIdUsuario(@PathVariable String idUsuario){
        List<PredicaoResponseDTO> predicoes = predicaoService.buscarPredicaoPorUsuarioId(idUsuario);
        return new ResponseEntity<>(predicoes, HttpStatus.OK);
    }
}
