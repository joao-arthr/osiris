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

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PredicaoFacade {
    private final FileUploadService fileUploadService;
    private final PredicaoService predicaoService;
    public PredicaoResponseDTO armazenarPredicao(MultipartFile imagem) throws IOException {
        String imgUrl = fileUploadService.uploadFile(imagem);
        return predicaoService.salvarPredicao(new Predicao(
                imgUrl,
                LocalDateTime.now(),
                Status.PROCESSANDO
        ));

    }
}
