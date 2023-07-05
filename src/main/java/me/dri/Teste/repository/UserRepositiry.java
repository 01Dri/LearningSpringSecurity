package me.dri.Teste.repository;

import me.dri.Teste.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiry extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
