package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Produtor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutorRepository extends MongoRepository<Produtor, String> {
}
