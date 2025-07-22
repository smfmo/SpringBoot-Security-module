package io.github.smfmo.sbootSecurity.infra.repository;


import io.github.smfmo.sbootSecurity.domain.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {}
