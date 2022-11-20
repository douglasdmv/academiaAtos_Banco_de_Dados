package com.api.bankingcontrol.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.bankingcontrol.models.CadastroClienteModel;
import com.api.bankingcontrol.repositories.CadastroClienteRepository;

@Service
public class CadastroClienteService {
	
	final CadastroClienteRepository cadastroClienteRepository;

	public CadastroClienteService(CadastroClienteRepository cadastroClienteRepository) {
		this.cadastroClienteRepository = cadastroClienteRepository;
	}

	@Transactional
	public CadastroClienteModel save(CadastroClienteModel cadastroClienteModel) {
		return cadastroClienteRepository.save(cadastroClienteModel);
	}
	
	public boolean existsByCpf(String cpf) {
		return cadastroClienteRepository.existsByCpf(cpf);
	}
	
	public List<CadastroClienteModel> findAll() {
		return cadastroClienteRepository.findAll();
	}
	
	public Optional<CadastroClienteModel> findById(Integer id) {
		return cadastroClienteRepository.findById(id);
	}
	
	@Transactional
	public void delete(CadastroClienteModel cadastroClienteModel) {
		cadastroClienteRepository.delete(cadastroClienteModel);
	}
}
