package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "predicao")
public class Predicao {
    private String id;
    private String imagem;
    private String classe;
    private BigDecimal acuracia;
    private LocalDateTime data;

    public Predicao(PredicaoRequestDTO predicaoRequestDTO){
        this.id = predicaoRequestDTO.id();
        this.imagem = predicaoRequestDTO.imagem();
        this.classe = predicaoRequestDTO.classe();
        this.acuracia = predicaoRequestDTO.acuracia();
        this.data = predicaoRequestDTO.data();
    }
}
