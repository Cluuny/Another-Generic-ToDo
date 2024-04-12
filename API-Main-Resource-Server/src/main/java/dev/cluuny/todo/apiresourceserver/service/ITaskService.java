package dev.cluuny.todo.apiresourceserver.service;

import dev.cluuny.todo.apiresourceserver.dto.task.TaskRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.task.TaskResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.TaskNotFoundException;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;

public interface ITaskService {
    TaskResponseDTO getTask(String taskId) throws TaskNotFoundException;

    String createTask(TaskRequestDTO dto) throws UserNotFoundException;

    void updateTask(String taskId, TaskRequestDTO dto) throws TaskNotFoundException;

    void deleteTask(String taskId);
}
