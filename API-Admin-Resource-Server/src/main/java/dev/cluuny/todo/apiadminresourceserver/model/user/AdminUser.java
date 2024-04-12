package dev.cluuny.todo.apiadminresourceserver.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.OAuth2Client;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_users")
public class AdminUser implements Serializable {
    @Id
    @UuidGenerator
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Role role;
    @OneToMany(mappedBy = "adminUser", cascade = CascadeType.ALL)
    private Set<OAuth2Client> clients;
}
