package com.papaya.osiris.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionDTO(LocalDateTime timestamp, HttpStatus status, String menssagem, String path) {
}
