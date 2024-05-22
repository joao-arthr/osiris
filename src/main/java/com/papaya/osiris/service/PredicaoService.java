package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;

import java.util.List;

public interface PredicaoService {
    PredicaoResponseDTO salvarPredicao(Predicao predicao);
    PredicaoResponseDTO buscarPredicaoPorId(String id);
    List<PredicaoResponseDTO> listarPredicoes();
}
