package io.github.smfmo.sbootSecurity.api;

import io.github.smfmo.sbootSecurity.domain.entity.Grupo;
import io.github.smfmo.sbootSecurity.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Grupo>> findAll() {
        List<Grupo> grupos = service.findAll();
        return ResponseEntity.ok(grupos);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> save(@RequestBody Grupo grupo) {
        service.save(grupo);
        return ResponseEntity.ok().build();
    }

}
