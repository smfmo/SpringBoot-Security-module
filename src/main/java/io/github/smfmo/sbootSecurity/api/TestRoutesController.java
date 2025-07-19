package io.github.smfmo.sbootSecurity.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRoutesController {

    @GetMapping("/public")
    public ResponseEntity<String> publicRoute() {
        return ResponseEntity.ok("public route access!");
    }

    @GetMapping("/private")
    public ResponseEntity<Object> privateRoute(Authentication authentication) {
        System.out.println(authentication.getClass());
        return ResponseEntity.ok(authentication.getPrincipal());
    }
}
