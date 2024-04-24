package dev.cluuny.todo.apiadminresourceserver.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(java.lang.RuntimeException.class)
    public ResponseEntity<String> runtimeExceptionHandler(java.lang.RuntimeException ex) {
        System.out.println("PASAAAAAAAAAAAAAAAA");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
