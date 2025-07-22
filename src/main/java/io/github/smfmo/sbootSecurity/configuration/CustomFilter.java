package io.github.smfmo.sbootSecurity.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

@Component
public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest requisicao,
                                    HttpServletResponse resposta,
                                    FilterChain cadeiaDeFiltro) throws ServletException, IOException {

        String secretHeader = requisicao.getHeader("X-secret");

        if (secretHeader != null){
            if (secretHeader.equals("secr3t")) {
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        "secreto", null, List.of(new SimpleGrantedAuthority("USER")));

                SecurityContext context = SecurityContextHolder.getContext();
                context.setAuthentication(auth);
            }
        }
        cadeiaDeFiltro.doFilter(requisicao, resposta);
    }
}
