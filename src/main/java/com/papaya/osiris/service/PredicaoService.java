package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;

import java.util.List;

public interface PredicaoService {
    PredicaoResponseDTO salvarPredicao(PredicaoRequestDTO requestDTO);
    PredicaoResponseDTO buscarPredicaoPorId(String id);
    List<PredicaoResponseDTO> listarPredicoes();
}
