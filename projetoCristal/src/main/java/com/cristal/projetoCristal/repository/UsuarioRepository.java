package com.cristal.projetoCristal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cristal.projetoCristal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
	public List<Usuario> findAllByCpfContainingIgnoreCase(String cpf);
	public Optional<Usuario> findByEmail(String email);
}
