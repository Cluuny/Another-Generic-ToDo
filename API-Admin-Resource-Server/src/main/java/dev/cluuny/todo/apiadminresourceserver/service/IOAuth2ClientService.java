package dev.cluuny.todo.apiadminresourceserver.service;

import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientRequest;
import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientResponse;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IOAuth2ClientService {
    List<OAuth2ClientResponse> getAllClients(String username) throws AdminUserNotFoundException;

    String createClient(OAuth2ClientRequest request, Authentication authentication) throws AdminUserNotFoundException;

    void deleteClient(String clientName, Authentication authentication) throws AdminUserNotFoundException;
}
