package dev.cluuny.todo.apiadminresourceserver.model.exceptions;


public class AdminUserNotFoundException extends Exception {
    public AdminUserNotFoundException(String username) {
        super("The Admin User: " + username + " wasn't found.");
    }
}
