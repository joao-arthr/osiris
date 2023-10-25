package com.papaya.osiris.entity;

import com.papaya.osiris.dto.AssinaturaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assinatura {
    private boolean ativa;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public Assinatura(AssinaturaDTO assinaturaDTO) {
        this.ativa = assinaturaDTO.ativa();
        this.dataInicio = assinaturaDTO.dataInicio();
        this.dataTermino = assinaturaDTO.dataTermino();
    }
}
