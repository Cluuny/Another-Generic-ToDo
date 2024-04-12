package dev.cluuny.todo.apiadminresourceserver.controller.advice;

import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminUserNotFoundHandler {
    @ExceptionHandler(AdminUserNotFoundException.class)
    public ResponseEntity<String> adminUserNotFoundHandler(AdminUserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
