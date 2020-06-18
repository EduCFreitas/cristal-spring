package com.cristal.projetoCristal.rest.DTO;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrinhoDTO {
	
	private Long id;
	private Long cdProduto;
	private Long cdCompra;
	private Date data;
}
