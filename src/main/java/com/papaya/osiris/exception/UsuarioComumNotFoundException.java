package com.papaya.osiris.exception;

public class UsuarioComumNotFoundException extends RuntimeException {
    private static final String MENSAGEM_PADRAO = "Usuario não encontrado. ID: ";
    public UsuarioComumNotFoundException(String id) {
        super(MENSAGEM_PADRAO + id);
    }

}

