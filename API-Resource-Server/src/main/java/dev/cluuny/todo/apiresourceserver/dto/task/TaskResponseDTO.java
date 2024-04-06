package dev.cluuny.todo.apiresourceserver.dto.task;

import dev.cluuny.todo.apiresourceserver.model.TaskStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO {
    private String id;
    private String title;
    private String description;
    private String creationDate;
    private String dueDate;
    private TaskStatus status;
}
