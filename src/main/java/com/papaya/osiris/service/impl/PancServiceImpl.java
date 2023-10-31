package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.PancRequestDTO;
import com.papaya.osiris.dto.response.PancResponseDTO;
import com.papaya.osiris.entity.Panc;
import com.papaya.osiris.exception.PancNotFoundException;
import com.papaya.osiris.repository.PancRepository;
import com.papaya.osiris.service.PancService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class PancServiceImpl implements PancService {

    private final PancRepository pancRepository;

    @Override
    public PancResponseDTO criarPanc(PancRequestDTO pancRequest, String url) {
        var panc = new Panc(pancRequest);
        panc.setImagem(url);
        return new PancResponseDTO(pancRepository.save(panc));
    }

    @Override
    public PancResponseDTO atualizarPanc(String id, PancRequestDTO pancRequest, String url) {
        Panc pancExistente = pancRepository.findById(id)
                .orElseThrow(() -> new PancNotFoundException(id));
        BeanUtils.copyProperties(pancRequest, pancExistente);
        pancExistente.setImagem(url);
        return new PancResponseDTO(pancRepository.save(pancExistente));
    }

    @Override
    public PancResponseDTO buscarPancPorId(String id) {
        Panc panc = pancRepository.findById(id)
                .orElseThrow(() -> new PancNotFoundException(id));
        return new PancResponseDTO(panc);
    }

    @Override
    public List<PancResponseDTO> listarTodasAsPancs() {
        List<Panc> todasAsPancs = pancRepository.findAll();
        return todasAsPancs.stream()
                .map(PancResponseDTO::new)
                .toList();
    }

    @Override
    public void excluirPancPorId(String id) {
        pancRepository.deleteById(id);
    }
}


