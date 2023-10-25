package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.ProdutorRequestDTO;
import com.papaya.osiris.dto.response.ProdutorResponseDTO;

import java.util.List;

public interface ProdutorService {
    List<ProdutorResponseDTO> listarTodosProdutores();
    ProdutorResponseDTO buscarProdutorPorId(String id);
    ProdutorResponseDTO criarProdutor(ProdutorRequestDTO produtorRequest);
    ProdutorResponseDTO atualizarProdutor(String id, ProdutorRequestDTO produtorRequest);
    void excluirProdutor(String id);
}

