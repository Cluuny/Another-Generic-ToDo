package dev.cluuny.todo.apiauthorizationserver.persistence.mapper;

import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.GrantType;
import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.OAuth2Client;
import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.RedirectURI;
import dev.cluuny.todo.apiauthorizationserver.model.oauth2client.Scope;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class OAuth2ClientMapper {
    public RegisteredClient mapToRegisteredClient(OAuth2Client client) {
        return RegisteredClient.withId(String.valueOf(client.getId()))
                .clientId(client.getClientName())
                .clientSecret("{noop}" + client.getClientSecret())
                .clientAuthenticationMethod(new ClientAuthenticationMethod(client.getAuthMethod()))
                .authorizationGrantTypes(this.mapGranTypes(client.getGrantTypes()))
                .redirectUris(this.mapRedirectUris(client.getRedirectURIS()))
                .scopes(this.mapScopes(client.getScopes()))
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(false).build())
                .build();
    }

    private Consumer<Set<String>> mapRedirectUris(Set<RedirectURI> redirectURISSet) {
        return redirectURIs -> {
            Set<String> mappedGrantTypes = redirectURISSet.stream()
                    .map(RedirectURI::getValue)
                    .collect(Collectors.toSet());
            redirectURIs.addAll(mappedGrantTypes);
        };
    }

    private Consumer<Set<AuthorizationGrantType>> mapGranTypes(Set<GrantType> grantTypesSet) {
        return authorizationGrantTypes -> {
            Set<AuthorizationGrantType> mappedGrantTypes = grantTypesSet.stream()
                    .map(grantType ->
                                    new AuthorizationGrantType(grantType.getValue())
                    )
                    .collect(Collectors.toSet());
            authorizationGrantTypes.addAll(mappedGrantTypes);
        };
    }

    private Consumer<Set<String>> mapScopes(Set<Scope> scopeSet) {
        return scopes -> {
            Set<String> mappedGrantTypes = scopeSet.stream()
                    .map(Scope::getValue)
                    .collect(Collectors.toSet());
            scopes.addAll(mappedGrantTypes);
        };
    }
}
