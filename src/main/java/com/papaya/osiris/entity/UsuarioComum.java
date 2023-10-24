package com.papaya.osiris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("usuario")
public class UsuarioComum extends Usuario {
    private List<ObjectId> pancsFavoritasId;
    private List<ObjectId> receitasSalvasId;
}
