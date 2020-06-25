package com.cristal.projetoCristal.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cristal.projetoCristal.model.Usuario;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String tipo;
	private boolean isAccountNonExpired;
	private boolean isCredentialsNonExpired;
	private boolean isAccountNonLocked;
	private boolean isEnabled;
	
	// Construtor
	public UserDetailsImpl(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.cpf = usuario.getCpf();
		this.tipo = usuario.getTipo();
		this.isAccountNonExpired=true;
		this.isCredentialsNonExpired=true;
		this.isEnabled=true;
		this.isAccountNonLocked=true;
	}
	
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTipo() {
		return tipo;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}
