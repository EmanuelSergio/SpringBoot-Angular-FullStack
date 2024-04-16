package io.github.emanuelSergio.clientes.model.repository;

import io.github.emanuelSergio.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
