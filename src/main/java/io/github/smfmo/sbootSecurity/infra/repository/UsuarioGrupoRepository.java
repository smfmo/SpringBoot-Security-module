package io.github.smfmo.sbootSecurity.infra.repository;

import io.github.smfmo.sbootSecurity.domain.entity.UsuarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, UUID> {
}
