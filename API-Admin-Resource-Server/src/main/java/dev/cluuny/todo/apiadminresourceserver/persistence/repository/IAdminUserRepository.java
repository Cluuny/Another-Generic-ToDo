package dev.cluuny.todo.apiadminresourceserver.persistence.repository;

import dev.cluuny.todo.apiadminresourceserver.model.user.AdminUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface IAdminUserRepository extends JpaRepository<AdminUser, UUID> {
    Optional<AdminUser> findAdminUserByUsername(String username);

    void deleteAdminUserByUsername(String username);
}
