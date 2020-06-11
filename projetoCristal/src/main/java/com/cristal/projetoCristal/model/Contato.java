package com.cristal.projetoCristal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CONTATO")
public class Contato {
	@Column(name = "cdContato")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nmContato")
	@NotNull
	@Size(min = 3, max = 80)
	private String nome;
	
	@Column(name = "cdTelefone")
	@NotNull
	@Size(min = 10, max = 11)
	private String telefone;
	
	@Column(name = "nmEmail")
	@NotNull
	@Size(min = 5, max = 120)
	private String email;
	
	@Column(name = "dsTexto")
	@NotNull
	@Size(min = 1, max = 1000)
	private String texto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
