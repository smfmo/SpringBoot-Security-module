package io.github.smfmo.sbootSecurity.service;

import io.github.smfmo.sbootSecurity.infra.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository repository;


}
