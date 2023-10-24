package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Produtor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutorRepository extends MongoRepository<Produtor, ObjectId> {
}
