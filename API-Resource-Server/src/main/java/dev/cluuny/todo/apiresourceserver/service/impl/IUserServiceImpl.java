package dev.cluuny.todo.apiresourceserver.service.impl;

import dev.cluuny.todo.apiresourceserver.dto.user.UserRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.user.UserResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.User;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.persistence.mapper.UserMapper;
import dev.cluuny.todo.apiresourceserver.persistence.repository.IUserRepository;
import dev.cluuny.todo.apiresourceserver.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO getUser(String userId) throws UserNotFoundException {
        User user = userRepository.findUserByUUID(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotFoundException(userId));
        return userMapper.fromUsertoUserResponseDTO(user);
    }

    @Override
    public String createUser(UserRequestDTO userRequestDTO) {
        User newUser = userMapper.fromRegistrationUserDTOToEntity(userRequestDTO);
        userRepository.save(newUser);
        return String.valueOf(newUser.getId());
    }

    @Override
    public void updateUser(String userId, UserRequestDTO userRequestDTO) throws UserNotFoundException {
        User userToUpdate = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotFoundException(userId));
        if (userRequestDTO.getName() != null) {
            userToUpdate.setName(userRequestDTO.getName());
        } else if (userRequestDTO.getLastName() != null) {
            userToUpdate.setLastName(userRequestDTO.getLastName());
        } else if (userRequestDTO.getEmail() != null) {
            userToUpdate.setEmail(userRequestDTO.getEmail());
        } else if (userRequestDTO.getPassword() != null) {
            userToUpdate.setPassword(userRequestDTO.getPassword());
        } else if (userRequestDTO.getBirthDate() != null) {
            userToUpdate
                    .setBirthDate(LocalDate.parse(userRequestDTO.getBirthDate(), DateTimeFormatter.ISO_DATE_TIME));
        }
        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(UUID.fromString(userId));
    }
}
