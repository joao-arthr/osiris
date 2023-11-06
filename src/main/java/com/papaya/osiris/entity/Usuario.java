package com.papaya.osiris.entity;

import com.papaya.osiris.dto.request.LoginRequestDTO;
import com.papaya.osiris.dto.request.UsuarioRequestDTO;
import com.papaya.osiris.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("usuario")
public class Usuario implements UserDetails {
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private List<String> pancsFavoritasId;
    private List<String> receitasSalvasId;
    private Perfil perfil;
    private Assinatura assinatura;
    private String imagem;

    public Usuario(
            String nome,
            String email,
            String senha,
            List<String> pancsFavoritasId,
            List<String> receitasSalvasId,
            Perfil perfil,
            Assinatura assinatura,
            String imagem
            ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pancsFavoritasId = pancsFavoritasId;
        this.receitasSalvasId = receitasSalvasId;
        this.perfil = perfil;
        this.assinatura = assinatura;
        this.imagem = imagem;
    }

    public Usuario(UsuarioRequestDTO usuarioRequest) {
        this.nome = usuarioRequest.nome();
        this.email = usuarioRequest.email();
        this.senha = usuarioRequest.senha();
        this.pancsFavoritasId = usuarioRequest.pancsFavoritasId();
        this.receitasSalvasId = usuarioRequest.receitasSalvasId();
        this.assinatura = new Assinatura(usuarioRequest.assinatura());
        this.imagem = usuarioRequest.imagem();
    }

    public Usuario(LoginRequestDTO login){
        this.email = login.email();
        this.senha = login.senha();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getPerfil().toString()));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
