package io.github.smfmo.sbootSecurity.api;

import io.github.smfmo.sbootSecurity.api.dto.UsuarioDto;
import io.github.smfmo.sbootSecurity.domain.entity.Usuario;
import io.github.smfmo.sbootSecurity.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> save(@RequestBody UsuarioDto dto){
        service.save(dto.usuario(), dto.permissoes());
        return ResponseEntity.ok().build();
    }

}
