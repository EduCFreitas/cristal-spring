package com.cristal.projetoCristal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristal.projetoCristal.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByCorContainingIgnoreCase(String cor);
	public List<Produto> findAllByTamanhoContainingIgnoreCase(String tamanho);
	public List<Produto> findAllByCategoriaContainingIgnoreCase(String categoria);

}
