package io.github.emanuelSergio.clientes.controller;
import io.github.emanuelSergio.clientes.model.entity.Usuario;
import io.github.emanuelSergio.clientes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Usuario user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return "Usuário já existe!";
        }

        userService.saveUser(user.getUsername(), user.getPassword());
        return "Usuário registrado com sucesso!";
    }
}
