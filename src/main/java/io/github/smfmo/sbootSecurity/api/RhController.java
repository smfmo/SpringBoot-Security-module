package io.github.smfmo.sbootSecurity.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rh")
@RequiredArgsConstructor
public class RhController {


    @GetMapping("/technical")
    @PreAuthorize("hasAnyRole('TECNICO_RH', 'ADMIN', 'GERENTE_RH')")
    public ResponseEntity<String> technical(){
        return ResponseEntity.ok("Success! -> access to the technician route!");
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('GERENTE_RH', 'ADMIN')")
    public ResponseEntity<String> manager(){
        return ResponseEntity.ok("Success! -> access to the manager route");
    }
}
