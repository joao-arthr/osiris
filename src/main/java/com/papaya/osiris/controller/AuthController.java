package com.papaya.osiris.controller;

import com.papaya.osiris.dto.request.LoginRequestDTO;
import com.papaya.osiris.dto.response.LoginResponseDTO;
import com.papaya.osiris.entity.Usuario;
import com.papaya.osiris.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO login){
        var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.email(),login.senha()));
        var token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
