package br.senac.df.spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.senac.df.spring.database.RepositorioContato;
import br.senac.df.spring.entidade.Contato;


@RestController
@RequestMapping("/Contato")
public class ContatoREST {
	
	
	@Autowired
	private RepositorioContato repositorio;
	
	// Crud - Listar, consultar, pesquisa, Read
	@GetMapping
	public List<Contato> listar(){
		return repositorio.findAll();
		
	}
	
	// Crud - Salvar, Criar, Create
	@PostMapping
	public void salvar(@RequestBody Contato contato) {
		repositorio.save(contato);
		
	}
	
	// Crud - Alterar, atualizar, Update
	@PutMapping
	public void alterar(@RequestBody Contato contato) {
		if(contato.getId()> 0) 
		repositorio.save(contato);
		
	}
	
	// Crud - Excluir, deletar, Delete
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		repositorio.deleteById(id);
		
	}
	
}
