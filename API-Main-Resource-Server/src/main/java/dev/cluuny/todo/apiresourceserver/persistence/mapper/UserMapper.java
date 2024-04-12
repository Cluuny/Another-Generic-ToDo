package dev.cluuny.todo.apiresourceserver.persistence.mapper;

import dev.cluuny.todo.apiresourceserver.dto.user.UserRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.user.UserResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User fromRegistrationUserDTOToEntity(UserRequestDTO dto) {
        return User.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .birthDate(LocalDate.parse(dto.getBirthDate(), DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public UserResponseDTO fromUsertoUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(String.valueOf(user.getId()))
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(String.valueOf(user.getBirthDate()))
                .build();
    }

}
