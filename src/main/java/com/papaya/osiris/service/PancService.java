package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.PancRequestDTO;
import com.papaya.osiris.dto.response.PancResponseDTO;

import java.util.List;

public interface PancService {
    PancResponseDTO criarPanc(PancRequestDTO pancRequest);
    PancResponseDTO atualizarPanc(String id, PancRequestDTO pancRequest);
    PancResponseDTO buscarPancPorId(String id);
    List<PancResponseDTO> listarTodasAsPancs();
    void excluirPancPorId(String id);
}
