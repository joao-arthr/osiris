package com.papaya.osiris.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.papaya.osiris.entity.Usuario;
import jakarta.servlet.http.HttpServletRequest;

public interface TokenService {
    String gerarToken(Usuario usuario);

    String validarToken(String token) throws JWTVerificationException;

    String extrirUsuarioId(String token);

    String recuperarToken(HttpServletRequest request);
}
