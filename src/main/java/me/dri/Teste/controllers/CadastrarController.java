package me.dri.Teste.controllers;

import jakarta.validation.Valid;
import me.dri.Teste.models.RegisterDTO;
import me.dri.Teste.models.User;
import me.dri.Teste.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastrarController {

    @Autowired
    private UserRepositiry repositiry;


    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrarUsers(@RequestBody @Valid RegisterDTO data) {
        if (this.repositiry.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.login(), encryptedPassword, data.role());
        this.repositiry.save(newUser);
        return ResponseEntity.ok().body(newUser);
    }
}
