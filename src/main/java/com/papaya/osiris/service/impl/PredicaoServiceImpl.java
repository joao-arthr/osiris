package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.PredicaoRequestDTO;
import com.papaya.osiris.dto.response.PredicaoResponseDTO;
import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.exception.PancNotFoundException;
import com.papaya.osiris.repository.PredicaoRepository;
import com.papaya.osiris.service.PredicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredicaoServiceImpl implements PredicaoService {
    private final PredicaoRepository predicaoRepository;

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
