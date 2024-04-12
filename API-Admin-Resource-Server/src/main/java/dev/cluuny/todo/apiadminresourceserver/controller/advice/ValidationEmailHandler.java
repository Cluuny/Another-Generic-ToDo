package dev.cluuny.todo.apiadminresourceserver.controller.advice;

import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationEmailHandler {
    @ExceptionHandler(ValidationEmailException.class)
    public ResponseEntity<String> validationEmailHandler(ValidationEmailException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
