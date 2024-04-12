package dev.cluuny.todo.apiresourceserver.model.exception;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String taskId) {
        super("Task with id: " + taskId + " wasn't found.");
    }
}
