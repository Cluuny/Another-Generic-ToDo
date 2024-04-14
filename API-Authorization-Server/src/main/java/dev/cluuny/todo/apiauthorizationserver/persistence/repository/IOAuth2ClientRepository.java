package dev.cluuny.todo.apiauthorizationserver.persistence.repository;

import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IOAuth2ClientRepository extends JpaRepository<OAuth2Client, UUID> {
    Optional<OAuth2Client> findOAuth2ClientByClientName(String name);
}
