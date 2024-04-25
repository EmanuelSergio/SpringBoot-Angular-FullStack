package io.github.emanuelSergio.clientes.model.repository;

import io.github.emanuelSergio.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
