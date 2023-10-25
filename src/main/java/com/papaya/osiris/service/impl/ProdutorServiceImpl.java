package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.ProdutorRequestDTO;
import com.papaya.osiris.dto.response.ProdutorResponseDTO;
import com.papaya.osiris.entity.Produtor;
import com.papaya.osiris.exception.ProdutorNotFoundException;
import com.papaya.osiris.repository.ProdutorRepository;
import com.papaya.osiris.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutorServiceImpl implements ProdutorService {
    private final ProdutorRepository produtorRepository;

    public List<ProdutorResponseDTO> listarTodosProdutores() {
        List<Produtor> produtores = produtorRepository.findAll();
        return produtores.stream().map(ProdutorResponseDTO::new).collect(Collectors.toList());
    }

    public ProdutorResponseDTO buscarProdutorPorId(String id) {
        Produtor produtor = produtorRepository.findById(id)
                .orElseThrow(() -> new ProdutorNotFoundException(id));
        return new ProdutorResponseDTO(produtor);
    }

    public ProdutorResponseDTO criarProdutor(ProdutorRequestDTO produtorRequest) {
        return new ProdutorResponseDTO(produtorRepository.save(new Produtor(produtorRequest)));
    }

    public ProdutorResponseDTO atualizarProdutor(String id, ProdutorRequestDTO produtorRequest) {
        Produtor produtorExistente = produtorRepository.findById(id)
                .orElseThrow(() -> new ProdutorNotFoundException(id));
        BeanUtils.copyProperties(produtorRequest, produtorExistente);
        return new ProdutorResponseDTO(produtorRepository.save(produtorExistente));
    }

    public void excluirProdutor(String id) {produtorRepository.deleteById(id);}
}
