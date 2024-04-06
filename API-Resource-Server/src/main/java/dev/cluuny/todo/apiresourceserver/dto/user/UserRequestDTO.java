package dev.cluuny.todo.apiresourceserver.dto.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
}
