package dev.cluuny.todo.apiauthorizationserver.service;

import dev.cluuny.todo.apiauthorizationserver.model.exception.OAuth2ClientNotFoundException;
import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.OAuth2Client;
import dev.cluuny.todo.apiauthorizationserver.persistence.mapper.OAuth2ClientMapper;
import dev.cluuny.todo.apiauthorizationserver.persistence.repository.IOAuth2ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OAuth2RegisteredClientRepository implements RegisteredClientRepository {

    private final IOAuth2ClientRepository clientRepository;
    private final OAuth2ClientMapper clientMapper;

    @Override
    public void save(RegisteredClient registeredClient) {
        //Client Creation isn't allowed
    }

    @Override
    public RegisteredClient findById(String id) {
        RegisteredClient registeredClient;
        try {
            OAuth2Client client = clientRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new OAuth2ClientNotFoundException(id));
            registeredClient = clientMapper.mapToRegisteredClient(client);
        } catch (OAuth2ClientNotFoundException e) {
            throw new RuntimeException(e);
        }
        return registeredClient;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        RegisteredClient registeredClient;
        try {
            OAuth2Client client = clientRepository.findOAuth2ClientByClientName(clientId)
                    .orElseThrow(() -> new OAuth2ClientNotFoundException(clientId));
            registeredClient = clientMapper.mapToRegisteredClient(client);
        } catch (OAuth2ClientNotFoundException e) {
            throw new RuntimeException(e);
        }
        return registeredClient;
    }
}
