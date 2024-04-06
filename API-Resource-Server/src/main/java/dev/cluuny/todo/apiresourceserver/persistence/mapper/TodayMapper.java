package dev.cluuny.todo.apiresourceserver.persistence.mapper;

import dev.cluuny.todo.apiresourceserver.dto.today.TodayResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodayMapper {

    private final TaskMapper taskMapper;

    public TodayResponseDTO formUserToUserTodayResponseDTO(User user) {
        return TodayResponseDTO.builder()
                .id(String.valueOf(user.getId()))
                .name(user.getName())
                .tasks(user.getTasks().stream()
                        .map(taskMapper::fromTaskToTaskResponseDTO).collect(Collectors.toSet()))
                .build();
    }
}
