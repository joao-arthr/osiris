package com.papaya.osiris.service.impl;

import com.papaya.osiris.dto.request.PancRequestDTO;
import com.papaya.osiris.dto.response.PancResponseDTO;
import com.papaya.osiris.entity.Panc;
import com.papaya.osiris.repository.PancRepository;
import com.papaya.osiris.service.PancService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class PancServiceImpl implements PancService {

    private PancRepository pancRepository;

    @Override
    public PancResponseDTO criarPanc(PancRequestDTO pancRequest) {
        Panc novaPanc = new Panc(
                new ObjectId(),
                pancRequest.getNome(),
                pancRequest.getDescricao(),
                pancRequest.getCultivo(),
                pancRequest.getImagem()
        );
        Panc pancSalva = pancRepository.save(novaPanc);
        return new PancResponseDTO(pancSalva);
    }

    @Override
    public PancResponseDTO atualizarPanc(String id, PancRequestDTO pancRequest) {
        Panc pancExistente = pancRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Panc não encontrada com o ID: " + id));

        pancExistente.setNome(pancRequest.getNome());
        pancExistente.setDescricao(pancRequest.getDescricao());
        pancExistente.setCultivo(pancRequest.getCultivo());
        pancExistente.setImagem(pancRequest.getImagem());

        Panc pancAtualizada = pancRepository.save(pancExistente);
        return new PancResponseDTO(pancAtualizada);
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


