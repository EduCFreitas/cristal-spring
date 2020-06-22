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

import com.cristal.projetoCristal.model.Carrinho;
import com.cristal.projetoCristal.model.Compra;
import com.cristal.projetoCristal.model.Produto;
import com.cristal.projetoCristal.repository.CarrinhoRepository;
import com.cristal.projetoCristal.repository.CompraRepository;
import com.cristal.projetoCristal.repository.ProdutoRepository;
import com.cristal.projetoCristal.rest.DTO.CarrinhoDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin(origins="*", allowedHeaders="*")
@RequiredArgsConstructor
public class CarrinhoController {
	
//	@Autowired
//	private CarrinhoRepository repository;
	
	private final CompraRepository compraRepository;
	private final ProdutoRepository produtoRepository;
	private final CarrinhoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Carrinho>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
//	@PostMapping
//	public ResponseEntity<Carrinho> post(@RequestBody Carrinho carrinho){
//		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carrinho));
//	}
	
	@PostMapping
	public Carrinho salvar(@RequestBody CarrinhoDTO dto) {
		Long cdCompra = dto.getCdCompra();
		Long cdProduto = dto.getCdProduto();
		
		Compra compra = compraRepository.findById(cdCompra)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compra inexistente."));
		Produto produto = produtoRepository.findById(cdProduto)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inexistente."));
		
		Carrinho carrinho = new Carrinho();
		carrinho.setCompra(compra);
		carrinho.setProduto(produto);
		carrinho.setId(dto.getId());
		carrinho.setData(dto.getData());
		
		return repository.save(carrinho);
	}
	
	@PutMapping
	public ResponseEntity<Carrinho> put (@RequestBody Carrinho carrinho) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(carrinho));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
