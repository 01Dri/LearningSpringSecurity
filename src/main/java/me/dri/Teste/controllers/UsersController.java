package me.dri.Teste.controllers;


import me.dri.Teste.models.User;
import me.dri.Teste.models.UserDTO;
import me.dri.Teste.repository.UserRepositiry;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UsersController {


    @Autowired
    private UserRepositiry repositiry;
    @GetMapping
    public List<UserDTO> findAll() {
        List< User> users = repositiry.findAll();
        return users.stream().map(user -> new UserDTO(user.getUsername())).collect(Collectors.toList());
    }
}
