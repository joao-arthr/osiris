package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Receita;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceitaRepository extends MongoRepository<Receita, ObjectId> {
}
