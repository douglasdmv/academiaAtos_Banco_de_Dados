package com.api.ordemservico.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.jackson.JsonComponent;

import com.api.ordemservico.model.PrestadorModel;
import com.api.ordemservico.model.ProcessoModel;
import com.api.ordemservico.model.ProdutoModel;

import lombok.Data;

@Data
@JsonComponent
public class OrdemServicoDto {
	
	@Valid
	private ProcessoModel processoModel;
	@Valid
	private PrestadorModel prestadorModel;
	@Valid
	private ProdutoModel produtoModel;
	@NotNull
	private float quantidade;
	@NotNull
	private float total;
}
