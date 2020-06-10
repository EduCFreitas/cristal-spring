package com.cristal.projetoCristal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristal.projetoCristal.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	public List<Contato> findAllByNomeContainingIgnoreCase(String nome);
	public List<Contato> findAllByEmailContainingIgnoreCase(String email);
}
