package com.sarawipay.client_microservice.Client.infrastructure.controller;

import com.sarawipay.client_microservice.Client.domain.GenericResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<GenericResponseEntity<Object>> handleNotFound(NoSuchElementException ex) {
        GenericResponseEntity<Object> response = new GenericResponseEntity<>(
                ex.getMessage(),
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseEntity<Object>> handleGeneralError(Exception ex) {
        GenericResponseEntity<Object> response = new GenericResponseEntity<>(
                "Error interno del servidor",
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
