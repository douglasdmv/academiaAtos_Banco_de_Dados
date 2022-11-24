package com.api.ordemservico.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.ordemservico.model.OrdemServicoModel;
import com.api.ordemservico.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	final OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
		this.ordemServicoRepository = ordemServicoRepository;
	}
	
	@Transactional
	public OrdemServicoModel save(OrdemServicoModel ordemServicoModel) {
		return ordemServicoRepository.save(ordemServicoModel);
	}
	
	public List<OrdemServicoModel> findAll() {
		return ordemServicoRepository.findAll();
	}
	
	public Optional<OrdemServicoModel> findById(Long id) {
		return ordemServicoRepository.findById(id);
	}
	
	@Transactional
	public void delete(OrdemServicoModel ordemServicoModel) {
		ordemServicoRepository.delete(ordemServicoModel);
	}
}
