package io.github.smfmo.sbootSecurity.service;

import io.github.smfmo.sbootSecurity.domain.entity.Grupo;
import io.github.smfmo.sbootSecurity.infra.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository repository;

    public List<Grupo> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void save(Grupo grupo) {
        repository.save(grupo);
    }

}
