package com.papaya.osiris.repository;

import com.papaya.osiris.entity.UsuarioComum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioComumRepository extends MongoRepository<UsuarioComum, String> {
}
