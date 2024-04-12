package dev.cluuny.todo.apiadminresourceserver.model.exceptions;

public class ValidationEmailException extends Exception {
    public ValidationEmailException(String email) {
        super("The email: " + email + " isn't a valid email.");
    }
}
