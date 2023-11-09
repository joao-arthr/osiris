package com.papaya.osiris.service.impl;
import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.entity.Receita;
import com.papaya.osiris.exception.PancNotFoundException;
import com.papaya.osiris.exception.ReceitaNotFoundException;
import com.papaya.osiris.exception.UsuarioNotFoundException;
import com.papaya.osiris.repository.ReceitaRepository;
import com.papaya.osiris.service.ReceitaService;
import com.papaya.osiris.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {
    private final UsuarioService usuarioService;
    private final ReceitaRepository receitaRepository;

    @Override
    public List<ReceitaResponseDTO> listarTodasReceitas() {
        var response = receitaRepository.findAll();
        if (response.isEmpty()) {
            throw new UsuarioNotFoundException("Nenhuma receita encontrada");
        }
        return response.stream()
                .map(ReceitaResponseDTO::fromReceita)
                .toList();
    }

    @Override
    public ReceitaResponseDTO encontrarReceitaPorId(String id) {
        var response = receitaRepository.findById(id)
                .orElseThrow(() -> new ReceitaNotFoundException(id));
        return new ReceitaResponseDTO(response);
    }

    @Override
    public ReceitaResponseDTO criarReceita(ReceitaRequestDTO receitaRequest){
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

    @Override
    public ReceitaResponseDTO salvarImagem(String id, String url){
        Receita receitaExistente = receitaRepository.findById(id)
                .orElseThrow(() -> new PancNotFoundException(id));
        receitaExistente.setImagem(url);
        return new ReceitaResponseDTO(receitaRepository.save(receitaExistente));
    }

    @Override
    public List<ReceitaResponseDTO> encontrarReitaPorUsuarioId(String id){
        var response = receitaRepository.findByUsuarioId(id);
        if (response.isEmpty()) {
            throw new UsuarioNotFoundException("Nenhuma receita encontrada");
        }
        return response.stream()
                .map(ReceitaResponseDTO::fromReceita)
                .toList();
    }
}

