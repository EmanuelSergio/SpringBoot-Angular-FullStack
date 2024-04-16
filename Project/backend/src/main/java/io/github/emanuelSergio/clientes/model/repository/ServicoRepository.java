package io.github.emanuelSergio.clientes.model.repository;

import io.github.emanuelSergio.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
