package com.cristal.projetoCristal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	@Column(name = "cdUsuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cdCpf", unique = true)
	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	
	@Column(name = "nmUsuario")
	@NotNull
	@Size(min = 3, max = 80)
	private String nome;
	
	@Column(name = "sgUsuario")
	@NotNull
	@Size(min = 3, max = 80)
	private String usuario;
	
	@Column(name = "nmEmail")
	@NotNull
	@Size(min = 5, max = 120)
	private String email;
	
	@Column(name = "cdTelefone")
	@Size(min = 10, max = 11)
	private String telefone;
	
	@Column(name = "cdSenha")
	@NotNull
	@Size(min = 8, max = 50)
	private String senha;
	
	@Column(name = "nmLogradouro")
	@NotNull
	@Size(min = 3, max = 150)
	private String logradouro;
	
	@Column(name = "cdResidencia")
	@NotNull
	@Size(min = 1, max = 10)
	private String numResidencia;
	
	@Column(name = "nmEstado")
	@NotNull
	@Size(min = 2, max = 20)
	private String estado;
	
	@Column(name = "nmCidade")
	@NotNull
	@Size(min = 2, max = 50)
	private String cidade;
	
	@Column(name = "nmBairro")
	@NotNull
	@Size(min = 3, max = 50)
	private String bairro;
	
	@Column(name = "cdCep")
	@NotNull
	@Size(min = 8, max = 8)
	private String cep;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumResidencia() {
		return numResidencia;
	}

	public void setNumResidencia(String numResidencia) {
		this.numResidencia = numResidencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
