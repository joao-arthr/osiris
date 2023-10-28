package com.papaya.osiris.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.papaya.osiris.entity.Usuario;

public interface TokenService {
    String gerarToken(Usuario usuario);

    String validarToken(String token) throws JWTVerificationException;
}
