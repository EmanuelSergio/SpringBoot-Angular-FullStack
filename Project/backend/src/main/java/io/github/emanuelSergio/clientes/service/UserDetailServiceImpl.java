package io.github.emanuelSergio.clientes.service;

import io.github.emanuelSergio.clientes.model.entity.Usuario;
import io.github.emanuelSergio.clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository; // Seu repositório que interage com o banco de dados

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscando o usuário pelo nome de usuário
        Usuario user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o nome: " + username));

        // Retornando o UserDetails para o Spring Security
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>()); // Aqui você pode adicionar as permissões/roles, se necessário
    }
}
