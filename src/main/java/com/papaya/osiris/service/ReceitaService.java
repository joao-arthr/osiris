package com.papaya.osiris.service;

import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ReceitaService {
    List<ReceitaResponseDTO> listarTodasReceitas();
    ReceitaResponseDTO encontrarReceitaPorId(String id);
    ReceitaResponseDTO criarReceita(Receita receita);
    ReceitaResponseDTO atualizarReceita(String id, Receita novaReceita);
    void deletarReceita(String id);
}
