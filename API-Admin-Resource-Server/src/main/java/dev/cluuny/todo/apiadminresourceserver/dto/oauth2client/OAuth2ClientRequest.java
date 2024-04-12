package dev.cluuny.todo.apiadminresourceserver.dto.oauth2client;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2ClientRequest implements Serializable {
    private String clientName;
    private String clientSecret;
    private String clientAuthMethod;
    private List<String> redirectURIList;
    private List<String> grantTypeList;
    private List<String> scopeList;
}
