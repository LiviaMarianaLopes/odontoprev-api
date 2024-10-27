package br.com.fiap.odontoprev.repository;

import br.com.fiap.odontoprev.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    UserDetails findByEmail(String email);
}
