package dev.cluuny.todo.apiadminresourceserver.persistence.repository;

import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.OAuth2Client;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface IOAuth2ClientRepository extends JpaRepository<OAuth2Client, UUID> {
    List<OAuth2Client> findAllByAdminUser_Id(UUID adminUserId);

    void deleteOAuth2ClientByClientNameAndAdminUser_Id(String clientName, UUID adminUserId);
}
