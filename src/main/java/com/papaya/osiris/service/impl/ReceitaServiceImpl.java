package com.papaya.osiris.service.impl;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import com.papaya.osiris.repository.ReceitaRepository;
import com.papaya.osiris.service.ReceitaService;
import lombok.RequiredArgsConstructor;
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
            throw new RuntimeException("Nenhuma receita encontrada");
        }
        return response.stream()
                .map(ReceitaResponseDTO::fromReceita)
                .collect(Collectors.toList());
    }

    @Override
    public ReceitaResponseDTO encontrarReceitaPorId(ObjectId id) {
        var response = receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada: " + id.toString()));
        return new ReceitaResponseDTO(response);
    }

    @Override
    public ReceitaResponseDTO criarReceita(Receita receita) {
        return new ReceitaResponseDTO(receitaRepository.save(receita));
    }

    @Override
    public ReceitaResponseDTO atualizarReceita(ObjectId id, Receita novaReceita) {
        Optional<Receita> receitaExistente = receitaRepository.findById(id);
        if (receitaExistente.isPresent()) {
            novaReceita.setId(id);
            return new ReceitaResponseDTO(receitaRepository.save(novaReceita));
        } else {
            return null;
        }
    }

    @Override
    public void deletarReceita(ObjectId id) {
        receitaRepository.deleteById(id);
    }
}

