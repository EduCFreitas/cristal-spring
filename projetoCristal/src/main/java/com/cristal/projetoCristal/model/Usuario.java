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

import lombok.Data;

@Entity
@Table(name = "TB_USUARIO")
@Data
public class Usuario {
	@Column(name = "cdUsuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cdCpf", unique = true)
	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	
	@Column(name = "nmUsuario", unique = true)
	@NotNull
	@Size(min = 3, max = 80)
	private String nome;
	
	@Column(name = "nmUsername")
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

	
}
