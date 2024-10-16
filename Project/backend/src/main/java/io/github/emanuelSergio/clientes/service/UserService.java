package io.github.emanuelSergio.clientes.service;

import io.github.emanuelSergio.clientes.model.entity.Usuario;
import io.github.emanuelSergio.clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    @Lazy
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario saveUser(String username, String password) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password)); // Encripta a senha


        return repository.save(usuario);
    }

    public Optional<Usuario> findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
