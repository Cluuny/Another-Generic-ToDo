package dev.cluuny.todo.apiadminresourceserver.controller;

import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientRequest;
import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientResponse;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import dev.cluuny.todo.apiadminresourceserver.service.IOAuth2ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth2-client")
public class OAuth2ClientRestController {

    private final IOAuth2ClientService oAuth2ClientService;

    @GetMapping("/all")
    public List<OAuth2ClientResponse> getAllClients(Authentication authentication) throws AdminUserNotFoundException {
        return oAuth2ClientService.getAllClients(authentication.getName());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createClient(@RequestBody OAuth2ClientRequest request, Authentication authentication) throws AdminUserNotFoundException {
        return oAuth2ClientService.createClient(request, authentication);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestParam("client-name") String client, Authentication authentication) throws AdminUserNotFoundException {
        oAuth2ClientService.deleteClient(client, authentication);
    }
}
