package com.papaya.osiris.exception;

import com.papaya.osiris.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ExceptionDTO> handleEmailDuplicadoException(EmailDuplicadoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDTO(ex.getMessage()));
    }
    @ExceptionHandler(PancNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(PancNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(ex.getMessage()));
    }
    @ExceptionHandler(ReceitaNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(ReceitaNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(ex.getMessage()));
    }
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(UsuarioNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(ex.getMessage()));
    }
}
