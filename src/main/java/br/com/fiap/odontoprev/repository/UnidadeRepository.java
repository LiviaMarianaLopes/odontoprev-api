package br.com.fiap.odontoprev.repository;

import br.com.fiap.odontoprev.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository  extends JpaRepository<Unidade, Long> {
}
