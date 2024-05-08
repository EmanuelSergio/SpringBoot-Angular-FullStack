package io.github.emanuelSergio.clientes.controller;

import io.github.emanuelSergio.clientes.controller.dto.LoginRequest;
import io.github.emanuelSergio.clientes.controller.dto.LoginResponse;
import io.github.emanuelSergio.clientes.model.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TokenController {
/*
    private final JwtEncoder jwtEncoder;


    private final UsuarioRepository userRepository;

    public TokenController(JwtEncoder jwtEncoder, UsuarioRepository userRepository){
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

       var user = userRepository.findByUsername(loginRequest.username());

       if(user.isEmpty()){
           throw new BadCredentialsException(("usuario ou senha invalido"));
       }
    }
*/
}
