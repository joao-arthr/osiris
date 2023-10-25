package com.papaya.osiris.exception;

public class ReceitaNotFoundException extends RuntimeException {
    private static final String MENSAGEM_PADRAO = "Receita não encontrada. ID: ";
    public ReceitaNotFoundException(String id) {
        super(MENSAGEM_PADRAO + id);
    }
}

