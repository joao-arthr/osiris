package com.papaya.osiris.exception;

import com.papaya.osiris.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ExceptionDTO> handleEmailDuplicadoException(EmailDuplicadoException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDTO(LocalDateTime.now(),
                HttpStatus.FORBIDDEN,
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")));
    }
    @ExceptionHandler(PancNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(PancNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDTO(LocalDateTime.now(),
                HttpStatus.FORBIDDEN,
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")));
    }
    @ExceptionHandler(ReceitaNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(ReceitaNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(LocalDateTime.now(),
                HttpStatus.FORBIDDEN,
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")));
    }
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePancNotFoundException(UsuarioNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(LocalDateTime.now(),
                HttpStatus.FORBIDDEN,
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")));
    }
}
