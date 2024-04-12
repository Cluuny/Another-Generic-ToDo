package dev.cluuny.todo.apiresourceserver.controller;

import dev.cluuny.todo.apiresourceserver.dto.today.TodayRequestDTO;
import dev.cluuny.todo.apiresourceserver.dto.today.TodayResponseDTO;
import dev.cluuny.todo.apiresourceserver.model.exception.UserNotFoundException;
import dev.cluuny.todo.apiresourceserver.service.ITodayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/today")
public class TodayRestController {
    private final ITodayService todayService;

    @GetMapping
    public TodayResponseDTO getToday(@RequestBody TodayRequestDTO request) throws UserNotFoundException {
        return todayService.getToday(request);
    }
}
