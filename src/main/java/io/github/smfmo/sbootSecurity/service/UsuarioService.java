package io.github.smfmo.sbootSecurity.service;

import io.github.smfmo.sbootSecurity.api.dto.UsuarioDto;
import io.github.smfmo.sbootSecurity.domain.entity.Grupo;
import io.github.smfmo.sbootSecurity.domain.entity.Usuario;
import io.github.smfmo.sbootSecurity.domain.entity.UsuarioGrupo;
import io.github.smfmo.sbootSecurity.infra.repository.GrupoRepository;
import io.github.smfmo.sbootSecurity.infra.repository.UsuarioGrupoRepository;
import io.github.smfmo.sbootSecurity.infra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;
    private final UsuarioGrupoRepository usuarioGrupoRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(Usuario usuario, List<String> grupos) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);

        List<UsuarioGrupo> listaUsuarioGrupo = grupos.stream().map(nomeGrupo -> {
            Optional<Grupo> possivelGrupo = grupoRepository.findByName(nomeGrupo);
            if (possivelGrupo.isPresent()) {
                Grupo grupo = possivelGrupo.get();
                return new UsuarioGrupo(usuario, grupo);
            }
            return null;
        }).filter(Objects::nonNull).toList();

        usuarioGrupoRepository.saveAll(listaUsuarioGrupo);
    }
}
