package dev.cluuny.todo.apiresourceserver.persistence.repository;

import dev.cluuny.todo.apiresourceserver.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITaskRepository extends JpaRepository<Task, UUID> {
}
