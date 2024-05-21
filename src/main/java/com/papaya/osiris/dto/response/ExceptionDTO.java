package com.papaya.osiris.dto.response;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public record ExceptionDTO(LocalDateTime timestamp, int status, String message, String path) {
}
