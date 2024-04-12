package dev.cluuny.todo.apiadminresourceserver.service.impl;

import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientRequest;
import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientResponse;
import dev.cluuny.todo.apiadminresourceserver.model.exceptions.AdminUserNotFoundException;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.OAuth2Client;
import dev.cluuny.todo.apiadminresourceserver.model.user.AdminUser;
import dev.cluuny.todo.apiadminresourceserver.persistence.mapper.OAuth2ClientMapper;
import dev.cluuny.todo.apiadminresourceserver.persistence.repository.IAdminUserRepository;
import dev.cluuny.todo.apiadminresourceserver.persistence.repository.IOAuth2ClientRepository;
import dev.cluuny.todo.apiadminresourceserver.service.IOAuth2ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OAuth2ClientServiceImpl implements IOAuth2ClientService {

    private final IOAuth2ClientRepository oAuth2ClientRepository;
    private final IAdminUserRepository adminUserRepository;
    private final OAuth2ClientMapper oAuth2ClientMapper;

    @Override
    public List<OAuth2ClientResponse> getAllClients(String username) throws AdminUserNotFoundException {
        AdminUser user = adminUserRepository.findAdminUserByUsername(username)
                .orElseThrow(() -> new AdminUserNotFoundException(username));
        List<OAuth2Client> clients = oAuth2ClientRepository.findAllByAdminUser_Id(user.getId());
        return clients.stream().map(oAuth2ClientMapper::fromEntityToResponse).toList();
    }

    @Override
    public String createClient(OAuth2ClientRequest request, Authentication authentication) throws AdminUserNotFoundException {
        AdminUser user = adminUserRepository.findAdminUserByUsername(authentication.getName())
                .orElseThrow(() -> new AdminUserNotFoundException(authentication.getName()));
        OAuth2Client newClient = oAuth2ClientMapper.formRequestToEntity(request);
        newClient.setAdminUser(user);
        newClient = oAuth2ClientRepository.save(newClient);
        System.out.println(newClient);
        return String.valueOf(newClient.getId());
    }

    @Override
    public void deleteClient(String clientName, Authentication authentication) throws AdminUserNotFoundException {
        AdminUser user = adminUserRepository.findAdminUserByUsername(authentication.getName())
                .orElseThrow(() -> new AdminUserNotFoundException(authentication.getName()));
        oAuth2ClientRepository.deleteOAuth2ClientByClientNameAndAdminUser_Id(clientName, user.getId());
    }
}
