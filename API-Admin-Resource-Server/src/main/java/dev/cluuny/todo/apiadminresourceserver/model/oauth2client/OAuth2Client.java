package dev.cluuny.todo.apiadminresourceserver.model.oauth2client;

import dev.cluuny.todo.apiadminresourceserver.model.user.AdminUser;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oauth2_clients")
public class OAuth2Client {
    @Id
    @UuidGenerator
    @Column(name = "client_id")
    private UUID id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "client_authentication_method")
    private String authMethod;

    @ManyToOne
    @JoinColumn(name = "adminuser_id", referencedColumnName = "id")
    private AdminUser adminUser;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "oauth2_client_redirect_uri",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "redirect_uri_id"))
    private Set<RedirectURI> redirectURIS;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "oauth2_client_grant_type",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "grant_type_id"))
    private Set<GrantType> grantTypes;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "oauth2_client_scopes",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "scope_id"))
    private Set<Scope> scopes;
}
