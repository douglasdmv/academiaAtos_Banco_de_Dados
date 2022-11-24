package com.api.ordemservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProcessoDto {
	
	@NotBlank
	private String processo;
	@NotNull
	private float valorunt;
}
