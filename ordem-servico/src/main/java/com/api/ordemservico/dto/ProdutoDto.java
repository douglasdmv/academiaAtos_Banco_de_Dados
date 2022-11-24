package com.api.ordemservico.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProdutoDto {
	
	@NotBlank
	private String descricao;
	@NotBlank
	private String cor;
	@NotBlank
	private String tamanho;
}
