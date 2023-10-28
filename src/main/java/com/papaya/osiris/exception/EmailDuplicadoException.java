package com.papaya.osiris.exception;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException() {
        super("E-mail já existe no sistema.");
    }
}
