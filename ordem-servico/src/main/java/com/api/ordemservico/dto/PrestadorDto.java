package com.api.ordemservico.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PrestadorDto {
	
	@NotBlank
	private String cpf;
	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	@NotBlank
	private String cidade;
	@NotBlank
	private String servico;
}
