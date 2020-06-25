package com.cristal.projetoCristal.service;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cristal.projetoCristal.model.UsuarioLogin;
import com.cristal.projetoCristal.model.Usuario;
import com.cristal.projetoCristal.model.UsuarioLogado;
import com.cristal.projetoCristal.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		// Instancia a encriptação
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// senhaEncoder recebe a senha do usuário encriptada
		String senhaEncoder = encoder.encode(usuario.getSenha());
		// Senha do usuário recebe sua versão encriptada, vinda de senhaEncoder
		usuario.setSenha(senhaEncoder);
		// Salva alteração no BD
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioLogado> Logar(UsuarioLogin usuarioLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// Busca no BD por usuário com email igual ao informado no login
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.getEmail());
		
		// Se não encontra correspondência, retorna o Optional vazio
		if(usuario.isPresent()==false)
			return Optional.empty();
		// Se encontra correspondência de email, mas as senhas não correspondem, retorna o Optional vazio
		if(encoder.matches(usuarioLogin.getSenha(), usuario.get().getSenha())==false)
			return Optional.empty();
		
		// Criação do token
		String auth = usuarioLogin.getEmail()+":"+usuarioLogin.getSenha();
		String encoding = Base64.getEncoder().encodeToString((auth).getBytes());
		String authHeader = "Basic "+encoding;
		
		// Instanciamento do UsuarioLogado
		UsuarioLogado usuarioLogado = new UsuarioLogado();
		usuarioLogado.setId(usuario.get().getId());
		usuarioLogado.setNome(usuario.get().getNome());
		usuarioLogado.setEmail(usuario.get().getEmail());
		usuarioLogado.setCpf(usuario.get().getCpf());
		usuarioLogado.setTipo(usuario.get().getTipo());
		usuarioLogado.setToken(authHeader);
		
		// Se tudo ok, retorna o Optional com o UsuarioLogado criado
		return Optional.ofNullable(usuarioLogado);
	}
}
