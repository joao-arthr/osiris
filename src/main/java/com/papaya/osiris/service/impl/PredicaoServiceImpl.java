package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.exception.PancNotFoundException;
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
    private final PredicaoRepository predicaoRepository;
    private final WebClient webClient;
    @Override
    public Mono<PredicaoResponseDTO> enviarPredicao(String imgUrl) {
        MultiValueMap<String, String> parts = new LinkedMultiValueMap<>();
        parts.add("imagem", imgUrl);
        return webClient.post()
                .uri("/predict")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(parts))
                .retrieve()
                .bodyToMono(PredicaoResponseDTO.class);
    }
    @Override
    public PredicaoResponseDTO salvarPredicao(Predicao predicao) {
        return new PredicaoResponseDTO(predicaoRepository.save(predicao));
    }

    @Override
    public PredicaoResponseDTO buscarPredicaoPorId(String id) {
        Predicao predicao = predicaoRepository.findById(id)
                .orElseThrow(() -> new PancNotFoundException(id));
        return new PredicaoResponseDTO(predicao);
    }

    @Override
    public List<PredicaoResponseDTO> listarPredicoes() {
        List<Predicao> todasAsPredicoes = predicaoRepository.findAll();
        return todasAsPredicoes.stream()
                .map(PredicaoResponseDTO::new)
                .toList();
    }
}
