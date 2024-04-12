package dev.cluuny.todo.apiadminresourceserver.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @GetMapping
    public String home() {
        return "This is the home page.";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return "redirect:" + logoutUrl(request);
    }

    private String logoutUrl(HttpServletRequest request) {
        return request.getContextPath() + "/logout";
    }
}
