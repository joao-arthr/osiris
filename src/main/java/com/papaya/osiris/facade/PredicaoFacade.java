package com.papaya.osiris.facade;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.enums.Status;
import com.papaya.osiris.exception.PancNotFoundException;
import com.papaya.osiris.service.FileUploadService;
import com.papaya.osiris.service.PredicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PredicaoFacade {
    private final FileUploadService fileUploadService;
    private final PredicaoService predicaoService;
    public Mono<PredicaoResponseDTO> armazenarPredicao(MultipartFile imagem) throws IOException {
        String imgUrl = fileUploadService.uploadFile(imagem);
        return predicaoService.enviarPredicao(imgUrl)
                .flatMap(predicaoResponseDTO -> {
                    Predicao predicao = new Predicao(
                            imgUrl,
                            predicaoResponseDTO.classe(),
                            predicaoResponseDTO.acuracia(),
                            LocalDateTime.now(),
                            Status.CONCLUIDA
                    );
                    predicaoService.salvarPredicao(predicao);
                    return Mono.just(predicaoResponseDTO);
                });
    }

}
