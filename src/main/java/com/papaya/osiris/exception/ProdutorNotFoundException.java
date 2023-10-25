package com.papaya.osiris.exception;

public class ProdutorNotFoundException extends RuntimeException {
    private static final String MENSAGEM_PADRAO = "Produtor não encontrado";
    public ProdutorNotFoundException(String id) {
        super(MENSAGEM_PADRAO + id);
    }
}

