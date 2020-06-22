package com.cristal.projetoCristal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristal.projetoCristal.model.UsuarioLogin;
import com.cristal.projetoCristal.model.Usuario;
import com.cristal.projetoCristal.model.UsuarioLogado;
import com.cristal.projetoCristal.repository.UsuarioRepository;
import com.cristal.projetoCristal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<Usuario>> GetByCpf(@PathVariable String cpf){
		return ResponseEntity.ok(repository.findAllByCpfContainingIgnoreCase(cpf));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Usuario>> GetByEmail(@PathVariable String email){
		return ResponseEntity.ok(repository.findAllByEmailContainingIgnoreCase(email));
	}
	
	// Cadastrar novos usuários
	@PostMapping
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}
	
	// Login no site
	@PostMapping("/login")
	public ResponseEntity<Object> Logar(@RequestBody UsuarioLogin usuarioLogin){
		Optional<UsuarioLogado> usuarioLogado = usuarioService.Logar(usuarioLogin);
		// Se o login do usuário for confirmado pelo UsuarioService, informa-se um ok e usuarioLogado recebe os dados
		if(usuarioLogado.isPresent())
			return ResponseEntity.ok(usuarioLogado.get());
		// Caso contrário, o acesso é negado
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado!");
	}
	
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.CadastrarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}


	
	
}
