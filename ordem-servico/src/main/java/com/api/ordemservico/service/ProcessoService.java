package com.api.ordemservico.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.ordemservico.model.ProcessoModel;
import com.api.ordemservico.repository.ProcessoRepository;

@Service
public class ProcessoService {
	
	final ProcessoRepository processoRepository;
	
	public ProcessoService(ProcessoRepository processoRepository) {
		this.processoRepository = processoRepository;
	}
	
	@Transactional
	public ProcessoModel save(ProcessoModel processoModel) {
		return processoRepository.save(processoModel);
	}
	
	public boolean existsByProcesso(String processo) {
		return processoRepository.existsByProcesso(processo);
	}
	
	public List<ProcessoModel> findAll() {
		return processoRepository.findAll();
	}
	
	public Optional<ProcessoModel> findById(Long id) {
		return processoRepository.findById(id);
	}
	
	@Transactional
	public void delete(ProcessoModel processoModel) {
		processoRepository.delete(processoModel);
	}
}
