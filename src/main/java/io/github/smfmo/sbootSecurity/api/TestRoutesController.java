package io.github.smfmo.sbootSecurity.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRoutesController {

    @GetMapping("/public")
    public ResponseEntity<String> publicRoute() {
        return ResponseEntity.ok( "public route access!");
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateRoute() {
        return ResponseEntity.ok("private route access!");
    }
}
