package dev.cluuny.todo.apiresourceserver.dto.today;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayRequestDTO {
    private String userId;
}
