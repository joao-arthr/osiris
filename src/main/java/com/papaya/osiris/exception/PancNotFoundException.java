package com.papaya.osiris.exception;

public class PancNotFoundException extends RuntimeException {
    private static final String MENSAGEM_PADRAO = "Panc não encontrada. ID: ";
    public PancNotFoundException(String id) {
        super(MENSAGEM_PADRAO + id);
    }
}

