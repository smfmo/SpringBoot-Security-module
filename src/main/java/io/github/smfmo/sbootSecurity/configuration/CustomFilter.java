package io.github.smfmo.sbootSecurity.configuration;

import io.github.smfmo.sbootSecurity.security.CustomAuthentication;
import io.github.smfmo.sbootSecurity.security.IdentificacaoUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest requisicao,
                                    HttpServletResponse resposta,
                                    FilterChain cadeiaDeFiltro) throws ServletException, IOException {

        String secretHeader = requisicao.getHeader("X-secret");

        if (secretHeader != null){
            if (secretHeader.equals("secr3t")) {

                UUID uuid = UUID.fromString(UUID.randomUUID().toString());

                var identificacaoUsuario = new IdentificacaoUsuario(
                        uuid,
                        "secret",
                        "secret",
                        List.of("USER")
                );

                Authentication auth = new CustomAuthentication(identificacaoUsuario);

                SecurityContext context = SecurityContextHolder.getContext();
                context.setAuthentication(auth);
            }
        }
        cadeiaDeFiltro.doFilter(requisicao, resposta);
    }
}
