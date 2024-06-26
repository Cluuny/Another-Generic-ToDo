package dev.cluuny.todo.apiauthorizationserver.persistence.repository;

import dev.cluuny.todo.apiauthorizationserver.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserByEmail(String email);
}
