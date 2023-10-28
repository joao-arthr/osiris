package com.papaya.osiris.dto;

import com.papaya.osiris.entity.Assinatura;

import java.time.LocalDate;

public record AssinaturaDTO(
        LocalDate dataInicio,
        LocalDate dataTermino,
        boolean ativa
) {
    public AssinaturaDTO(Assinatura assinatura) {
        this(assinatura.getDataInicio(), assinatura.getDataTermino(), assinatura.isAtiva());
    }
}
