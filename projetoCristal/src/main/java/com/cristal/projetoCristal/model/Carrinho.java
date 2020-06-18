package com.cristal.projetoCristal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "TB_CARRINHO")
@Data
public class Carrinho {
	
	@Column(name = "cdCarrinho")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdProduto")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdCompra")
	private Compra compra;
	
	@Column(name = "dtCarrinho")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

}
