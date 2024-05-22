package com.papaya.osiris.dto.request;

import com.papaya.osiris.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PredicaoRequestDTO(
        String id,
        String imagem,
        String classe,
        BigDecimal acuracia,
        LocalDateTime data,
        Status status
) {
}
