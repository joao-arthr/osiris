package com.papaya.osiris.service;

import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ReceitaService {
    List<ReceitaResponseDTO> listarTodasReceitas();
    ReceitaResponseDTO encontrarReceitaPorId(ObjectId id);
    ReceitaResponseDTO criarReceita(Receita receita);
    ReceitaResponseDTO atualizarReceita(ObjectId id, Receita novaReceita);
    void deletarReceita(ObjectId id);
}
