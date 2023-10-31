package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ReceitaService {
    List<ReceitaResponseDTO> listarTodasReceitas();
    ReceitaResponseDTO encontrarReceitaPorId(String id);
    ReceitaResponseDTO criarReceita(ReceitaRequestDTO receitaRequest, String url);
    ReceitaResponseDTO atualizarReceita(String id, ReceitaRequestDTO novaReceita, String url);
    void deletarReceita(String id);
}
