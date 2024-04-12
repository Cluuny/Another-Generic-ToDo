package dev.cluuny.todo.apiadminresourceserver.dto.adminuser;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserRequestDTO implements Serializable {
    private String username;
    private String password;
    private String email;
    private String role;
}
