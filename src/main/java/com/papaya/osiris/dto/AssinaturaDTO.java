package com.papaya.osiris.dto;

import java.time.LocalDate;

public record AssinaturaDTO(
        String tipo,
        LocalDate dataInicio,
        LocalDate dataTermino,
        boolean ativa
) {}
