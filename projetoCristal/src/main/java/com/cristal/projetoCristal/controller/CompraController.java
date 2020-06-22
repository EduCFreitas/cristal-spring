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

import com.cristal.projetoCristal.model.Compra;
import com.cristal.projetoCristal.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins="*", allowedHeaders="*")
public class CompraController {
	@Autowired
	private CompraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Compra>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compra> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Compra> post(@RequestBody Compra compra){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(compra));
	}
	
	@PutMapping
	public ResponseEntity<Compra> put (@RequestBody Compra compra) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(compra));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
