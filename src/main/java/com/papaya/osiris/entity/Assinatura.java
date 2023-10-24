package com.papaya.osiris.entity;

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
}
