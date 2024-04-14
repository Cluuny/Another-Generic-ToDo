package dev.cluuny.todo.apiauthorizationserver.model.oauth2client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scopes")
public class Scope {
    @Id
    @UuidGenerator
    @Column(name = "scope_id")
    private UUID id;

    @Column(name = "value")
    private String value;
}
