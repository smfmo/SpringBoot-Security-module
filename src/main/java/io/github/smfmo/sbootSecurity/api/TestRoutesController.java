package io.github.smfmo.sbootSecurity.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRoutesController {

    @GetMapping("/public")
    public ResponseEntity<String> publicRoute() {
        return ResponseEntity.ok("Public route access!");
    }

    @GetMapping("/private")
    public ResponseEntity<Object> privateRoute(Authentication authentication) {
        return ResponseEntity.ok("Private route access! -> " + authentication.getPrincipal());
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminRoute(){
        return ResponseEntity.ok("Admin route access!");
    }
}
