package dev.cluuny.todo.apiadminresourceserver.service;

import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserRequestDTO;
import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserResponseDTO;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;

import java.util.List;

public interface IAdminUserService {
    AdminUserResponseDTO getUser(String username) throws AdminUserNotFoundException;

    List<AdminUserResponseDTO> getAllUsers();

    AdminUserResponseDTO createUser(AdminUserRequestDTO dto) throws ValidationEmailException;

    void updateUser(AdminUserRequestDTO dto) throws AdminUserNotFoundException, ValidationEmailException;

    void deleteUser(String username);
}
