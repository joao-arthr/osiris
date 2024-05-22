package com.papaya.osiris.service;

import com.papaya.osiris.dto.request.ReceitaRequestDTO;
import com.papaya.osiris.dto.response.ReceitaResponseDTO;
import com.papaya.osiris.dto.response.UsuarioResponseDTO;
import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReceitaService {
    List<ReceitaResponseDTO> listarTodasReceitas();
    ReceitaResponseDTO encontrarReceitaPorId(String id);
    ReceitaResponseDTO criarReceita(ReceitaRequestDTO receitaRequest);
    ReceitaResponseDTO substituirReceita(String id, ReceitaRequestDTO novaReceita);
    void deletarReceita(String id);
    ReceitaResponseDTO salvarImagem(String id, String url);
    List<ReceitaResponseDTO> encontrarReitaPorUsuarioId(String id);
    ReceitaResponseDTO atualizarReceita(String id, Map<String, Object> receitaRequest);
}
