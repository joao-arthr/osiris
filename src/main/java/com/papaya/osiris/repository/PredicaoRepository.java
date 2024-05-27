package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Predicao;
import com.papaya.osiris.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PredicaoRepository extends MongoRepository<Predicao, String> {
    List<Predicao> findByUsuarioId(String usuarioId);
}
