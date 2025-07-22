package io.github.smfmo.sbootSecurity.api.dto;

import io.github.smfmo.sbootSecurity.domain.entity.Usuario;
import java.util.List;

public record UsuarioDto(
        Usuario usuario,
        List<String> permissoes) {
}
