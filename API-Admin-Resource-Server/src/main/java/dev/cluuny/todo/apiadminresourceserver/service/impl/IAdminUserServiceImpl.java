package dev.cluuny.todo.apiadminresourceserver.service.impl;

import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserRequestDTO;
import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserResponseDTO;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;
import dev.cluuny.todo.apiadminresourceserver.model.security.SecurityAdminUser;
import dev.cluuny.todo.apiadminresourceserver.model.user.AdminUser;
import dev.cluuny.todo.apiadminresourceserver.model.user.Role;
import dev.cluuny.todo.apiadminresourceserver.persistence.mapper.AdminUserMapper;
import dev.cluuny.todo.apiadminresourceserver.persistence.repository.IAdminUserRepository;
import dev.cluuny.todo.apiadminresourceserver.service.IAdminUserService;
import dev.cluuny.todo.apiadminresourceserver.service.utils.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IAdminUserServiceImpl implements IAdminUserService, UserDetailsService {

    private final IAdminUserRepository adminUserRepository;
    private final AdminUserMapper adminUserMapper;
    private final UtilService utilService;

    @Override
    public AdminUserResponseDTO getUser(String username) throws AdminUserNotFoundException {
        AdminUser adminUser = adminUserRepository.findAdminUserByUsername(username)
                .orElseThrow(() -> new AdminUserNotFoundException(username));
        return adminUserMapper.fromEntityToResponse(adminUser);
    }

    @Override
    public List<AdminUserResponseDTO> getAllUsers() {
        List<AdminUser> adminUsers = adminUserRepository.findAll();
        return adminUsers.stream().map(adminUserMapper::fromEntityToResponse).toList();
    }

    @Override
    public AdminUserResponseDTO createUser(AdminUserRequestDTO dto) throws ValidationEmailException {
        AdminUser newAdminUser = adminUserMapper.fromRequestDTOtoEntity(dto);
        return adminUserMapper.fromEntityToResponse(adminUserRepository.save(newAdminUser));
    }

    @Override
    public void updateUser(AdminUserRequestDTO dto) throws AdminUserNotFoundException, ValidationEmailException {
        AdminUser user = adminUserRepository.findAdminUserByUsername(dto.getUsername())
                .orElseThrow(() -> new AdminUserNotFoundException(dto.getUsername()));
        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword());
        } else if (dto.getEmail() != null) {
            user.setEmail(utilService.validateEmail(dto.getEmail()));
        } else if (dto.getRole() != null) {
            user.setRole(Role.valueOf(dto.getRole()));
        }
        adminUserRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        adminUserRepository.deleteAdminUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AdminUser adminUser = adminUserRepository.findAdminUserByUsername(username)
                    .orElseThrow(() -> new AdminUserNotFoundException(username));
            return SecurityAdminUser.builder()
                    .user(adminUser)
                    .build();
        } catch (AdminUserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
