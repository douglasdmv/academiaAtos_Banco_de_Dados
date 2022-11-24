package com.api.ordemservico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "processos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long processoId;
	@Column(nullable = false, unique = true, length = 50)
	private String processo;
	@Column(nullable = false, name="valor_unitario")
	private float valorunt;
	
}
