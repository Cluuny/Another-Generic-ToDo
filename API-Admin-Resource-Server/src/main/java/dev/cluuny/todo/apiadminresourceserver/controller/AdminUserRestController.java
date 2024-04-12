package dev.cluuny.todo.apiadminresourceserver.controller;

import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserRequestDTO;
import dev.cluuny.todo.apiadminresourceserver.dto.adminuser.AdminUserResponseDTO;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;
import dev.cluuny.todo.apiadminresourceserver.service.IAdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AdminUserRestController {

    private final IAdminUserService adminUserService;

    @GetMapping("/{username}")
    @PreAuthorize("@utilService.validateUsernameAuthenticated(#username)")
    public AdminUserResponseDTO getAdminUserByUsername(@PathVariable @Param("username") String username) throws AdminUserNotFoundException {
        return adminUserService.getUser(username);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AdminUserResponseDTO> getAllAdminUsers() {
        return adminUserService.getAllUsers();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUserResponseDTO createAdminUser(@RequestBody AdminUserRequestDTO dto) throws ValidationEmailException {
        return adminUserService.createUser(dto);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@utilService.validateUsernameAuthenticated(#dto.username)")
    public void updateAdminUser(@RequestBody @Param("dto") AdminUserRequestDTO dto) throws ValidationEmailException, AdminUserNotFoundException {
        adminUserService.updateUser(dto);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@utilService.validateUsernameAuthenticated(#username)")
    public void deleteAdminUser(@PathVariable @Param("username") String username) {
        adminUserService.deleteUser(username);
    }
}
