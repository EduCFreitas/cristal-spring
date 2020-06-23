package com.cristal.projetoCristal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "TB_PRODUTO")
@Data
public class Produto {
	
	@Column(name = "cdProduto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nmCategoria")
	@NotNull
	@Size (min = 3, max = 20)
	private String categoria;
	
	@Column(name = "qtEstoque")
	@NotNull
	@Min(0)
	private int qtdEstoque;
	
	@Column(name = "vlProduto")
	@NotNull
	@Digits(integer=3,fraction=2)
	@Min(0)
	private double valor;
	
	@Column(name = "nmCor")
	@NotNull
	@Size (min = 3, max = 20)
	private String cor;
	
	@Column(name = "nmTamanho")
	@NotNull
	@Size (min = 1, max = 20)
	private String tamanho;
	
	@Column(name = "dsProduto")
	@Size (min = 3, max = 200)
	private String descricao;
	
	@Column(name = "nmProduto")
	@NotNull 
	@Size (min = 3, max = 40)
	private String nome;
	
	@Column(name = "cdFoto")
	@NotNull
	@Size (min = 1, max = 255)
	private String foto;
	
}
