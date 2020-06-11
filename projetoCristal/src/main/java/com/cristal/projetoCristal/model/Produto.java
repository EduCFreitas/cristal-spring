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

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
	
	@Column(name = "cdProduto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	private String foto;
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
	
	
}
