package dev.cluuny.todo.apiresourceserver.dto.task;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private String creationDate;
    private String dueDate;
    private String userId;
    private String status;
}
