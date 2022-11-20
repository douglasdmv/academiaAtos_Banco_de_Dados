package com.api.bankingcontrol.dtos;

import javax.validation.constraints.NotBlank;

public class CadastroClienteDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	@NotBlank
	private String datanasc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	
	
}
