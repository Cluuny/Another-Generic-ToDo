package dev.cluuny.todo.apiresourceserver.persistence.repository;

import dev.cluuny.todo.apiresourceserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT e FROM User e WHERE e.id = :id")
    Optional<User> findUserByUUID(@Param("id") UUID id);
}
