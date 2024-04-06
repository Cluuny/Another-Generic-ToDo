package dev.cluuny.todo.apiresourceserver.service;

import dev.cluuny.todo.apiresourceserver.dto.user.UserRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.today.TodayResponseDTO;
import dev.cluuny.todo.apiresourceserver.dto.user.UserResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;

public interface IUserService {
    UserResponseDTO getUser(String userId) throws UserNotFoundException;

    String createUser(UserRequestDTO userRequestDTO);

    void updateUser(String userId, UserRequestDTO userRequestDTO) throws UserNotFoundException;

    void deleteUser(String userId);
}
