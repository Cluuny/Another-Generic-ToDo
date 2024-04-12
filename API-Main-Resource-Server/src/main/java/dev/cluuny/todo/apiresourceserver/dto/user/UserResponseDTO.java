package dev.cluuny.todo.apiresourceserver.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String birthDate;
}
