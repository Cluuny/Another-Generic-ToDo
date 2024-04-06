package dev.cluuny.todo.apiresourceserver.persistence.mapper;

import dev.cluuny.todo.apiresourceserver.dto.task.TaskRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.task.TaskResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.Task;
import dev.cluuny.todo.apiresourceserver.model.TaskStatus;
import dev.cluuny.todo.apiresourceserver.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class TaskMapper {

    public Task formTaskRequestToTask(TaskRequestDTO dto, User user) {
        return Task.builder()
                .id(UUID.randomUUID())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .creationDate(LocalDateTime.parse(dto.getCreationDate(), DateTimeFormatter.ISO_DATE_TIME))
                .dueDate(LocalDateTime.parse(dto.getDueDate(), DateTimeFormatter.ISO_DATE_TIME))
                .status(TaskStatus.PENDING)
                .user(user)
                .build();
    }

    public TaskResponseDTO fromTaskToTaskResponseDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(String.valueOf(task.getId()))
                .title(task.getTitle())
                .description(task.getDescription())
                .creationDate(String.valueOf(task.getCreationDate()))
                .dueDate(String.valueOf(task.getCreationDate()))
                .status(task.getStatus())
                .build();
    }
}
