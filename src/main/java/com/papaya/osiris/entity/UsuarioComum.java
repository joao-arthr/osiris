package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.UsuarioComumRequestDTO;
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
    private List<String> pancsFavoritasId;
    private List<String> receitasSalvasId;

    public UsuarioComum(UsuarioComumRequestDTO usuarioComumRequest) {
        super(
                usuarioComumRequest.nome(),
                usuarioComumRequest.email(),
                usuarioComumRequest.senha(),
                usuarioComumRequest.imagem()
        );
        this.pancsFavoritasId = usuarioComumRequest.pancsFavoritasId();
        this.receitasSalvasId = usuarioComumRequest.receitasSalvasId();
    }
}
