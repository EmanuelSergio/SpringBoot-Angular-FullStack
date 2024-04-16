package io.github.emanuelSergio.clientes;

import io.github.emanuelSergio.clientes.model.entity.Cliente;
import io.github.emanuelSergio.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ClientesApplication {

	@Autowired
	ClienteRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(ClientesApplication.class, args);




	}


}
