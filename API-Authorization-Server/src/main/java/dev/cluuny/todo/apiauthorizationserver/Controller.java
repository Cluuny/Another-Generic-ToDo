package dev.cluuny.todo.apiauthorizationserver;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/demo")
    public String demo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTENTICADO");
        return auth.toString();
    }
}
