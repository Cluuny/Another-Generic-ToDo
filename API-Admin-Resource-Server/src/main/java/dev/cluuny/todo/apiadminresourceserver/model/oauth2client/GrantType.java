package dev.cluuny.todo.apiadminresourceserver.model.oauth2client;

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
@Table(name = "grant_types")
public class GrantType {
    @Id
    @UuidGenerator
    @Column(name = "grant_type_id")
    private UUID id;

    @Column(name = "value")
    private String value;
}
