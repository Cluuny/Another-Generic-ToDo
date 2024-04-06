package dev.cluuny.todo.apiresourceserver.model.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userId) {
        super("User with id: " + userId + " wasn't found.");
    }
}
