package dev.cluuny.todo.apiadminresourceserver.controller.advice;

import dev.cluuny.todo.apiadminresourceserver.model.exceptions.OAuth2ClientNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OAuth2ClientNotFoundHandler {
    @ExceptionHandler(OAuth2ClientNotFoundException.class)
    public ResponseEntity<String> oauth2ClientNotFoundHandler(OAuth2ClientNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
