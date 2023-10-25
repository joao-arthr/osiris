package com.papaya.osiris.service.impl;
import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import com.papaya.osiris.exception.ReceitaNotFoundException;
import com.papaya.osiris.exception.ResourceNotFoundException;
import com.papaya.osiris.repository.ReceitaRepository;
import com.papaya.osiris.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {
    private final ReceitaRepository receitaRepository;

    @Override
    public List<ReceitaResponseDTO> listarTodasReceitas() {
        var response = receitaRepository.findAll();
        if (response.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma receita encontrada");
        }
        return response.stream()
                .map(ReceitaResponseDTO::fromReceita)
                .collect(Collectors.toList());
    }

    @Override
    public ReceitaResponseDTO encontrarReceitaPorId(String id) {
        var response = receitaRepository.findById(id)
                .orElseThrow(() -> new ReceitaNotFoundException(id));
        return new ReceitaResponseDTO(response);
    }

    @Override
    public ReceitaResponseDTO criarReceita(ReceitaRequestDTO receitaRequest) {
        return new ReceitaResponseDTO(receitaRepository.save(new Receita(receitaRequest)));
    }

    @Override
    public ReceitaResponseDTO atualizarReceita(String id, ReceitaRequestDTO receitaRequest) {
        Receita receitaExistente = receitaRepository.findById(id)
                .orElseThrow(() -> new ReceitaNotFoundException(id));
        BeanUtils.copyProperties(receitaRequest, receitaExistente);
        return new ReceitaResponseDTO(receitaRepository.save(receitaExistente));
    }

    @Override
    public void deletarReceita(String id) {
        receitaRepository.deleteById(id);
    }
}

