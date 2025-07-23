package io.github.smfmo.sbootSecurity.infra.repository;

import io.github.smfmo.sbootSecurity.domain.entity.Usuario;
import io.github.smfmo.sbootSecurity.domain.entity.UsuarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, UUID> {

    @Query("""
        select distinct g.name
        from UsuarioGrupo ug
        join ug.grupo g
        join ug.usuario u
        where u = ?1
    """)
    List<String> findPermissoesByUsuario(Usuario usuario);
}
