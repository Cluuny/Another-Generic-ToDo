package dev.cluuny.todo.apiresourceserver.service;

import dev.cluuny.todo.apiresourceserver.dto.today.TodayRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.today.TodayResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;

public interface ITodayService {
    TodayResponseDTO getToday(TodayRequestDTO dto) throws UserNotFoundException;
}
