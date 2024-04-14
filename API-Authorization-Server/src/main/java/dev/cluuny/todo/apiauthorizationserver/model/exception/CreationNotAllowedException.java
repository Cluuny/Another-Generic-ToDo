package dev.cluuny.todo.apiauthorizationserver.model.exception;

public class CreationNotAllowedException extends Exception{
    public CreationNotAllowedException(){
        super("Client creation isn't allowed!");
    }
}
