package dev.cluuny.todo.apiadminresourceserver.persistence.mapper;

import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserRequestDTO;
import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserResponseDTO;
import dev.cluuny.todo.apiadminresourceserver.model.user.AdminUser;
import dev.cluuny.todo.apiadminresourceserver.model.user.Role;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;
import dev.cluuny.todo.apiadminresourceserver.service.utils.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminUserMapper {

    private final UtilService utilService;

    public AdminUser fromRequestDTOtoEntity(AdminUserRequestDTO dto) throws ValidationEmailException {
        return AdminUser.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(utilService.validateEmail(dto.getEmail()))
                .role(Role.valueOf(dto.getRole()))
                .build();
    }

    public AdminUserResponseDTO fromEntityToResponse(AdminUser entity) {
        return AdminUserResponseDTO.builder()
                .id(String.valueOf(entity.getId()))
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(String.valueOf(entity.getRole()))
                .build();
    }
}
