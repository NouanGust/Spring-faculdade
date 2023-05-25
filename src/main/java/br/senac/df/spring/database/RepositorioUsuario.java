package br.senac.df.spring.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senac.df.spring.entidade.Usuario;

public interface RepositorioUsuario extends JpaRepository <Usuario, Long> {
	
	@Query(value="select u from Usuario u where upper(trim(u.nome)) like %?1%")
	List<Usuario> buscarPorNome(String name);
	
	
}
