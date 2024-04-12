package dev.cluuny.todo.apiresourceserver.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    @OneToMany(targetEntity = Task.class, mappedBy = "user")
    private Set<Task> tasks;
}
