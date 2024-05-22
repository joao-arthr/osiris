package com.papaya.osiris.dto.response;

import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PredicaoResponseDTO(
        String id,
        String imagem,
        String classe,
        BigDecimal acuracia,
        LocalDateTime data,
        Status status) {

    public PredicaoResponseDTO(Predicao predicao){
        this(predicao.getId(),
                predicao.getImagem(),
                predicao.getClasse(),
                predicao.getAcuracia(),
                predicao.getData(),
                predicao.getStatus());
    }
}
