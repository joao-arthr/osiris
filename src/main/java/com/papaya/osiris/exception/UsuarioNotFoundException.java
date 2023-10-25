package com.papaya.osiris.exception;

public class UsuarioNotFoundException extends RuntimeException {
    private static final String MENSAGEM_PADRAO = "Usuario Admin não encontrado. ID: ";
    public UsuarioNotFoundException(String id) {
        super(MENSAGEM_PADRAO + id);
    }
}

