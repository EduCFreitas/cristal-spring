package com.cristal.projetoCristal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cristal.projetoCristal.model.Usuario;
import com.cristal.projetoCristal.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		// Instancia Usuario busscando por email no BD
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		
		// Se não há correspondência, informa que o usuário é inválido
		if(usuario.isPresent()==false)
			throw new UsernameNotFoundException("Usuário inválido!");
		
		// Caso haja correspondencia, instancia detalhes do usuário
		UserDetailsImpl userDetailsImp = new UserDetailsImpl(usuario.get());
		return userDetailsImp; 
	}
}
