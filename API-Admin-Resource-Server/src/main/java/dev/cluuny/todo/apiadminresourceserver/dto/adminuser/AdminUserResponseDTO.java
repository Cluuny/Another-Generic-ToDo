package dev.cluuny.todo.apiadminresourceserver.dto.adminuser;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserResponseDTO implements Serializable {
    private String id;
    private String username;
    private String email;
    private String role;
}
