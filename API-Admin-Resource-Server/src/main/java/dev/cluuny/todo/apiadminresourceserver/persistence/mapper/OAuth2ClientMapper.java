package dev.cluuny.todo.apiadminresourceserver.persistence.mapper;

import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientRequest;
import dev.cluuny.todo.apiadminresourceserver.dto.oauth2client.OAuth2ClientResponse;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.GrantType;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.OAuth2Client;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.RedirectURI;
import dev.cluuny.todo.apiadminresourceserver.model.oauth2client.Scope;
import dev.cluuny.todo.apiadminresourceserver.service.utils.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OAuth2ClientMapper {

    private final UtilService utilService;

    public OAuth2Client formRequestToEntity(OAuth2ClientRequest request) {
        return OAuth2Client.builder()
                .clientName(request.getClientName())
                .clientSecret(request.getClientSecret())
                .authMethod(utilService.validateAuthenticationMethod(request.getClientAuthMethod()))
                .redirectURIS(this.mapToRedirectURI(request.getRedirectURIList()))
                .grantTypes(this.maptoGrantType(request.getGrantTypeList()))
                .scopes(this.maptoScope(request.getScopeList()))
                .build();
    }

    public OAuth2ClientResponse fromEntityToResponse(OAuth2Client client) {
        return OAuth2ClientResponse.builder()
                .clientName(client.getClientName())
                .redirectURIList(client.getRedirectURIS().stream().map(RedirectURI::getValue).toList())
                .grantTypeList(client.getGrantTypes().stream().map(GrantType::getValue).toList())
                .scopeList(client.getScopes().stream().map(Scope::getValue).toList())
                .build();
    }


    public Set<RedirectURI> mapToRedirectURI(List<String> rawList) {
        return rawList.stream().map(redirectUri -> RedirectURI.builder().value(redirectUri).build()).collect(Collectors.toSet());
    }

    public Set<GrantType> maptoGrantType(List<String> rawList) {
        return rawList.stream().map(redirectUri -> GrantType.builder().value(redirectUri).build()).collect(Collectors.toSet());
    }

    public Set<Scope> maptoScope(List<String> rawList) {
        return rawList.stream().map(redirectUri -> Scope.builder().value(redirectUri).build()).collect(Collectors.toSet());
    }
}
