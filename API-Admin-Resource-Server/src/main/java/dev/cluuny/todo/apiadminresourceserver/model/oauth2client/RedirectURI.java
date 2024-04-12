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
@Table(name = "redirect_uris")
public class RedirectURI {
    @Id
    @UuidGenerator
    @Column(name = "redirect_uri_id")
    private UUID id;

    @Column(name = "value")
    private String value;
}
