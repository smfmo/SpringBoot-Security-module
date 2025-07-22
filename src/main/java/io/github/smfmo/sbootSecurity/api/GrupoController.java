package io.github.smfmo.sbootSecurity.api;

import io.github.smfmo.sbootSecurity.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {

        private final GrupoService service;

}
