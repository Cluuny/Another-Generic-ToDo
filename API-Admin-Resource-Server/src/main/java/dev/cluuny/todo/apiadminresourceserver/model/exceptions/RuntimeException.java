package dev.cluuny.todo.apiadminresourceserver.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeException {
    @ExceptionHandler(java.lang.RuntimeException.class)
    public ResponseEntity<String> runtimeExceptionHandler(java.lang.RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
