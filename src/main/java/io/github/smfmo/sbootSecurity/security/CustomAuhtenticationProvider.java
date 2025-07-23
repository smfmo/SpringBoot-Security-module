package io.github.smfmo.sbootSecurity.security;

import io.github.smfmo.sbootSecurity.domain.entity.Usuario;
import io.github.smfmo.sbootSecurity.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuhtenticationProvider implements AuthenticationProvider {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Usuario usuario = usuarioService.findByUsername(username);

        if (usuario != null) {
            boolean senhasBatem = passwordEncoder.matches(password, usuario.getPassword());
            if (senhasBatem) {
                IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario(
                        usuario.getId(),
                        usuario.getName(),
                        usuario.getUsername(),
                        usuario.getPermissions()
                );
                return new CustomAuthentication(identificacaoUsuario);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
