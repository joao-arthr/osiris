package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.PancRequestDTO;
import com.papaya.osiris.dto.response.PancResponseDTO;
import com.papaya.osiris.entity.Panc;
import com.papaya.osiris.exception.ResourceNotFoundException;
import com.papaya.osiris.repository.PancRepository;
import com.papaya.osiris.service.PancService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PancServiceImpl implements PancService {
    private PancRepository pancRepository;

    @Override
    public PancResponseDTO criarPanc(PancRequestDTO pancRequest) {
        return new PancResponseDTO(pancRepository.save(new Panc(pancRequest)));
    }

    @Override
    public PancResponseDTO atualizarPanc(String id, PancRequestDTO pancRequest) {
        Panc pancExistente = pancRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Panc não encontrada com o ID: " + id));
        BeanUtils.copyProperties(pancRequest, pancExistente);
        return new PancResponseDTO(pancRepository.save(pancExistente));
    }

    @Override
    public PancResponseDTO buscarPancPorId(String id) {
        Panc panc = pancRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Panc não encontrada com o ID: " + id));
        return new PancResponseDTO(panc);
    }

    @Override
    public List<PancResponseDTO> listarTodasAsPancs() {
        List<Panc> todasAsPancs = pancRepository.findAll();
        return todasAsPancs.stream()
                .map(PancResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void excluirPancPorId(String id) {
        pancRepository.deleteById(new ObjectId(id));
    }
}


