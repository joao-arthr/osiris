package com.papaya.osiris.service;

import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ReceitaService {
    List<Receita> listarTodasReceitas();
    Optional<Receita> encontrarReceitaPorId(ObjectId id);
    Receita criarReceita(Receita receita);
    Receita atualizarReceita(ObjectId id, Receita novaReceita);
    void deletarReceita(ObjectId id);
}
