package com.papaya.osiris.dto;

import java.time.LocalDate;

public record AssinaturaDTO(
        LocalDate dataInicio,
        LocalDate dataTermino,
        boolean ativa
) {}
