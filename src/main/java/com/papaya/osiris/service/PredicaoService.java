package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PredicaoService {
    Mono<PredicaoResponseDTO> enviarPredicao(String imgUrl);
    PredicaoResponseDTO salvarPredicao(Predicao predicao);
    List<PredicaoResponseDTO> buscarPredicaoPorUsuarioId(String usuarioId);
}
