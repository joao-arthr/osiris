package com.papaya.osiris.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    @Value("${jwt.secret}")
    private String secret;


    @Override
    public String gerarToken(Usuario usuario) throws JWTCreationException {
        return JWT.create()
                .withIssuer("auth-api")
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withExpiresAt(
                        LocalDate.now()
                                .plusDays(1)
                                .atStartOfDay(ZoneOffset.of("-03:00"))
                                .toInstant()
                ).sign(Algorithm.HMAC256(secret));
    }

    @Override
    public String validarToken(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .getSubject();
    }
}
