package me.dri.Teste.services;

import me.dri.Teste.models.User;
import me.dri.Teste.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
   private  UserRepositiry userRepositiry;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepositiry.findByLogin(login);
    }

}
