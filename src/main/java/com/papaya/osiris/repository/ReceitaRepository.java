package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReceitaRepository extends MongoRepository<Receita, String> {
    List<Receita> findByUsuarioId(String usuarioId);
}
