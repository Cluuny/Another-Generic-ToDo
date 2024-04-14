package dev.cluuny.todo.apiauthorizationserver.model.exception;

public class OAuth2ClientNotFoundException extends Exception{
    public OAuth2ClientNotFoundException(String clientName){
        super("Client " + clientName + " wasn't found.");
    }
}
