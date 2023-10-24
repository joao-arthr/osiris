package com.papaya.osiris.repository;

import com.papaya.osiris.entity.Panc;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PancRepository extends MongoRepository<Panc, ObjectId> {
}
