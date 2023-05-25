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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.senac.df.spring.database.RepositorioUsuario;
import br.senac.df.spring.entidade.Usuario;

@RestController
@RequestMapping("/Usuario")
public class UsuarioREST {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	@GetMapping
	public List<Usuario> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping
	public void  salvar(@RequestBody Usuario usuario) {
		repositorio.save(usuario);
	}
	
	@PutMapping
	public void alterar(@RequestBody Usuario usuario) {
		if(usuario.getId()> 0) 
		repositorio.save(usuario);	
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		repositorio.deleteById(id);
		
	}
	
	@GetMapping(value="buscarporid")
	public Usuario buscarPorId(@RequestParam(name="iduser") Long iduser) {
		return repositorio.findById(iduser).get();	
	
	}
	
	@GetMapping(value="buscarpornome")
	public List<Usuario> buscarPorNome(@RequestParam(name="name")String name){
		return repositorio.buscarPorNome(name);
	}
	
	
	

}
