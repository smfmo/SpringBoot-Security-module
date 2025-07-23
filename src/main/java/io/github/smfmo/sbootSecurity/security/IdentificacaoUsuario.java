package io.github.smfmo.sbootSecurity.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class IdentificacaoUsuario {

    private UUID id;

    private String name;

    private String login;

    private List<String> permissions;

    public IdentificacaoUsuario(UUID id,
                                String name,
                                String login,
                                List<String> permissions) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.permissions = permissions;
    }

    public List<String> getPermissions() {
        if (permissions == null) {
            permissions = new ArrayList<>();
        }
        return permissions;
    }
}
