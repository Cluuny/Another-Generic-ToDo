package dev.cluuny.todo.apiadminresourceserver.service.utils;

import dev.cluuny.todo.apiadminresourceserver.model.exceptions.ValidationEmailException;
import dev.cluuny.todo.apiadminresourceserver.model.security.SecurityAdminUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

@Service
public class UtilService {
    public String validateEmail(String email) throws ValidationEmailException {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?´{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (email.matches(regex)) {
            return email;
        } else {
            throw new ValidationEmailException(email);
        }
    }

    public String validateAuthenticationMethod(String toValidate) {
        return switch (toValidate) {
            case "client_secret_basic", "client_secret_post", "client_secret_jwt", "private_key_jwt", "none" ->
                    toValidate;
            default -> throw new RuntimeException("Invalid or Missing Authentication Method.");
        };
    }

    public boolean validateUsernameAuthenticated(String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityAdminUser authenticatedUser = (SecurityAdminUser) authentication.getPrincipal();
        System.out.println(authenticatedUser);
        return authenticatedUser.getUsername().equals(username);
    }
}
