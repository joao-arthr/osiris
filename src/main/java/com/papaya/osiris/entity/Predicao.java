package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.enums.Status;
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
    private Status status;

    public Predicao(PredicaoRequestDTO predicaoRequestDTO){
        this.imagem = predicaoRequestDTO.imagem();
    }

    public Predicao(String imagem, String classe, BigDecimal acuracia, LocalDateTime data, Status status){
        this.imagem = imagem;
        this.classe = classe;
        this.acuracia = acuracia;
        this.data = data;
        this.status = status;
    }
}
