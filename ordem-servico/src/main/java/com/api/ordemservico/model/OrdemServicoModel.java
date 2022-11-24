package com.api.ordemservico.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordens_servicos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOrdem;
	@Column(name = "data_emissao")
	private LocalDate dataEmissão;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "processo_id", referencedColumnName = "processoId", nullable = true)
	private ProcessoModel processoModel;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prestador_id", referencedColumnName = "prestadorId", nullable = true)
	private PrestadorModel prestadorModel;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "produto_id", referencedColumnName = "produtoId", nullable = true)
	private ProdutoModel produtoModel;
	@Column(nullable = false, name = "quantidade_pecas")
	private float quantidade;
	@Column(nullable = false, name = "valor_total")
	private float total;
	
}
