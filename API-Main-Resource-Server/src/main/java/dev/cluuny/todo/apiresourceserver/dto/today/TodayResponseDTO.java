package dev.cluuny.todo.apiresourceserver.dto.today;

import dev.cluuny.todo.apiresourceserver.dto.task.TaskResponseDTO;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayResponseDTO implements Serializable {
    private String id;
    private String name;
    private Set<TaskResponseDTO> tasks;
}
