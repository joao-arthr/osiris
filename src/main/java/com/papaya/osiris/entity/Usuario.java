package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String imagem;

    public Usuario(String nome, String email, String senha, String imagem) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.imagem = imagem;
    }

    public Usuario(UsuarioRequestDTO usuarioRequest) {
        this.nome = usuarioRequest.nome();
        this.email = usuarioRequest.email();
        this.senha = usuarioRequest.senha();
        this.imagem = usuarioRequest.imagem();
    }
}
