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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
	@CPF
	@Size(min = 11, max = 11)
	private String cpf;
	
	@Column(name = "nmUsuario")
	@NotNull
	@Size(min = 3, max = 80)
	private String nome;
	
	@Column(name = "nmEmail", unique = true)
	@NotNull
	@Email
	@Size(min = 5, max = 120)
	private String email;
	
	@Column(name = "cdTelefone")
	@Size(min = 10, max = 11)
	private String telefone;
	
	@Column(name = "cdSenha")
	@NotNull
	private String senha;
	
	@Column(name = "nmEndereco")
	@Size(min = 3, max = 150)
	private String endereco;
	
	@Column(name = "cdCep")
	@Size(min = 8, max = 8)
	private String cep;
	
	@Column(name = "dsUsuario")
	private String tipo;
	
	@Column(name = "dtCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	
}
