package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Predicao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PredicaoRepository extends MongoRepository<Predicao, String> {
}
