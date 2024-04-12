package dev.cluuny.todo.apiresourceserver.service.impl;

import dev.cluuny.todo.apiresourceserver.dto.today.TodayRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.today.TodayResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.User;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.persistence.mapper.TodayMapper;
import dev.cluuny.todo.apiresourceserver.persistence.repository.IUserRepository;
import dev.cluuny.todo.apiresourceserver.service.ITodayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ITodayServiceImpl implements ITodayService {

    private final IUserRepository userRepository;
    private final TodayMapper todayMapper;

    @Override
    public TodayResponseDTO getToday(TodayRequestDTO dto) throws UserNotFoundException {
        User user = userRepository.findUserByUUID(UUID.fromString(dto.getUserId()))
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        return todayMapper.formUserToUserTodayResponseDTO(user);
    }
}
