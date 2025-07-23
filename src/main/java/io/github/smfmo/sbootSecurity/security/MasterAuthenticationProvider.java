package io.github.smfmo.sbootSecurity.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MasterAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var username = authentication.getName();
        var password = (String) authentication.getCredentials();

        String usernameMaster = "admin";
        String passwordMaster = "admin";

        if (username.equals(usernameMaster) && password.equals(passwordMaster)) {
            UUID uuid = UUID.fromString(UUID.randomUUID().toString());

            IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario(
                    uuid, "admin", usernameMaster, List.of("ADMIN"));

            return new CustomAuthentication(identificacaoUsuario);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
