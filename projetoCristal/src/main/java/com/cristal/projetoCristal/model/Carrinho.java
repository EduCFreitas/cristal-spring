package com.cristal.projetoCristal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CARRINHO")
public class Carrinho {
	
	@Column(name = "cdCarrinho")
	@Id
	private long idCarrinho;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdProduto", referencedColumnName = "cdProduto")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdCompra", referencedColumnName = "cdCompra")
	private Compra compra;
	
	@Column(name = "dtCarrinho")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
	
}
