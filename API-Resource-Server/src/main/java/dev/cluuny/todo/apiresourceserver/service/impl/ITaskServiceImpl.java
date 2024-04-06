package dev.cluuny.todo.apiresourceserver.service.impl;

import dev.cluuny.todo.apiresourceserver.dto.task.TaskRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.task.TaskResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.Task;
import dev.cluuny.todo.apiresourceserver.model.TaskStatus;
import dev.cluuny.todo.apiresourceserver.model.User;
import dev.cluuny.todo.apiresourceserver.model.exception.TaskNotFoundException;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.persistence.mapper.TaskMapper;
import dev.cluuny.todo.apiresourceserver.persistence.repository.ITaskRepository;
import dev.cluuny.todo.apiresourceserver.persistence.repository.IUserRepository;
import dev.cluuny.todo.apiresourceserver.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ITaskServiceImpl implements ITaskService {
    private final ITaskRepository taskRepository;
    private final IUserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDTO getTask(String taskId) throws TaskNotFoundException {
        Task task = taskRepository.findById(UUID.fromString(taskId))
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        return taskMapper.fromTaskToTaskResponseDTO(task);
    }

    @Override
    public String createTask(TaskRequestDTO dto) throws UserNotFoundException {
        User user = userRepository.findUserByUUID(UUID.fromString(dto.getUserId()))
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        Task newTask = taskMapper.formTaskRequestToTask(dto, user);
        taskRepository.save(newTask);
        return String.valueOf(newTask.getId());
    }

    @Override
    public void updateTask(String taskId, TaskRequestDTO dto) throws TaskNotFoundException {
        Task task = taskRepository.findById(UUID.fromString(taskId))
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        if (dto.getTitle() != null) {
            task.setTitle(dto.getTitle());
        } else if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        } else if (dto.getDueDate() != null) {
            task.setDueDate(LocalDateTime.parse(dto.getDueDate(), DateTimeFormatter.ISO_DATE_TIME));
        } else if (dto.getStatus() != null) {
            task.setStatus(TaskStatus.valueOf(dto.getStatus()));
        }
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(String taskId) {
        taskRepository.deleteById(UUID.fromString(taskId));
    }
}
