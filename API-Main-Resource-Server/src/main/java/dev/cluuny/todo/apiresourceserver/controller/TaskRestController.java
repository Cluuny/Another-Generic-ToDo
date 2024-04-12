package dev.cluuny.todo.apiresourceserver.controller;

import dev.cluuny.todo.apiresourceserver.dto.task.TaskRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.task.TaskResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.TaskNotFoundException;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskRestController {

    private final ITaskService taskService;

    @GetMapping("/{taskId}")
    public TaskResponseDTO getTask(@PathVariable String taskId) throws TaskNotFoundException {
        return taskService.getTask(taskId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createTask(@RequestBody TaskRequestDTO dto) throws UserNotFoundException {
        return taskService.createTask(dto);
    }

    @PatchMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@PathVariable String taskId, @RequestBody TaskRequestDTO dto) throws TaskNotFoundException {
        taskService.updateTask(taskId, dto);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable String taskId) {
        taskService.deleteTask(taskId);
    }

}
