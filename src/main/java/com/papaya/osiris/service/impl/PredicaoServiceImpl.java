package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.repository.PredicaoRepository;
import com.papaya.osiris.service.PredicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredicaoServiceImpl implements PredicaoService {
    private final  PredicaoRepository predicaoRepository;
    private final WebClient webClient;

    @Override
    public Mono<PredicaoResponseDTO> enviarPredicao(String imgUrl) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/predict")
                        .build(0))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new PredicaoRequestDTO(imgUrl))
                .retrieve()
                .bodyToMono(PredicaoResponseDTO.class);
    }
    @Override
    public PredicaoResponseDTO salvarPredicao(Predicao predicao) {
        return new PredicaoResponseDTO(predicaoRepository.save(predicao));
    }

    @Override
    public List<PredicaoResponseDTO> buscarPredicaoPorUsuarioId(String usuarioId) {
        List<Predicao> predicoes = predicaoRepository.findByUsuarioId(usuarioId);
        return predicoes.stream()
                .map(PredicaoResponseDTO::new)
                .toList();
    }
}
