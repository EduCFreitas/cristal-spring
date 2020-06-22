package com.cristal.projetoCristal.controller;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import com.cristal.projetoCristal.model.Compra;
import com.cristal.projetoCristal.model.Usuario;
import com.cristal.projetoCristal.model.UsuarioCompra;
import com.cristal.projetoCristal.repository.CompraRepository;
import com.cristal.projetoCristal.repository.UsuarioCompraRepository;
import com.cristal.projetoCristal.repository.UsuarioRepository;
import com.cristal.projetoCristal.rest.DTO.UsuarioCompraDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios-compras")
@CrossOrigin(origins="*", allowedHeaders="*")
@RequiredArgsConstructor
public class UsuarioCompraController {
//	@Autowired
//	private UsuarioCompraRepository repository;
	
	private final UsuarioRepository usuarioRepository;
	private final CompraRepository compraRepository;
	private final UsuarioCompraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioCompra>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioCompra> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
//	@PostMapping
//	public ResponseEntity<UsuarioCompra> post(@RequestBody UsuarioCompra usuario){
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
//	}
	
	@PostMapping
	public UsuarioCompra salvar(@RequestBody UsuarioCompraDTO dto) {
		Long cdUsuario = dto.getCdUsuario();
		Long cdCompra = dto.getCdCompra();
		
		Usuario usuario = usuarioRepository.findById(cdUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário inexistente."));
		Compra compra = compraRepository.findById(cdCompra)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compra inexistente."));
		
		UsuarioCompra usuarioCompra = new UsuarioCompra();
		usuarioCompra.setUsuario(usuario);
		usuarioCompra.setCompra(compra);
		usuarioCompra.setId(dto.getId());
		
		return repository.save(usuarioCompra);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioCompra> put (@RequestBody UsuarioCompra usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}


	
	
}

