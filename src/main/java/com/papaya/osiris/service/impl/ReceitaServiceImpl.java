package com.papaya.osiris.service.impl;
import com.papaya.osiris.entity.Receita;
import com.papaya.osiris.repository.ReceitaRepository;
import com.papaya.osiris.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaRepository receitaRepository;


    @Override
    public List<Receita> listarTodasReceitas() {
        return receitaRepository.findAll();
    }

    @Override
    public Optional<Receita> encontrarReceitaPorId(ObjectId id) {
        return receitaRepository.findById(id);
    }

    @Override
    public Receita criarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

    @Override
    public Receita atualizarReceita(ObjectId id, Receita novaReceita) {
        Optional<Receita> receitaExistente = receitaRepository.findById(id);
        if (receitaExistente.isPresent()) {
            novaReceita.setId(id);
            return receitaRepository.save(novaReceita);
        } else {
            return null; // Ou lançar uma exceção, caso a receita não exista
        }
    }

    @Override
    public void deletarReceita(ObjectId id) {
        receitaRepository.deleteById(id);
    }
}

