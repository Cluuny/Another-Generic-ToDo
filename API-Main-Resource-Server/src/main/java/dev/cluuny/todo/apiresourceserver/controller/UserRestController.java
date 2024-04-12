package dev.cluuny.todo.apiresourceserver.controller;

import dev.cluuny.todo.apiresourceserver.dto.user.UserRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.user.UserResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class UserRestController {

    private final IUserService userService;

    @GetMapping("/{userId}")
    private UserResponseDTO getUser(@PathVariable String userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserRequestDTO dto, @PathVariable String userId) throws UserNotFoundException {
        userService.updateUser(userId, dto);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
