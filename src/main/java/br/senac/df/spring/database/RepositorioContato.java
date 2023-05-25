package br.senac.df.spring.database;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senac.df.spring.entidade.Contato;

public interface RepositorioContato extends JpaRepository<Contato, Long> {

}
