package com.api.ordemservico.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.ordemservico.model.PrestadorModel;
import com.api.ordemservico.repository.PrestadorRepository;

@Service
public class PrestadorService {
	final PrestadorRepository prestadorRepository;
	
	public PrestadorService(PrestadorRepository prestadorRepository) {
		this.prestadorRepository = prestadorRepository;
	}
	
	@Transactional
	public PrestadorModel save(PrestadorModel prestadorModel) {
		return prestadorRepository.save(prestadorModel);
	}
	
	public boolean existsByCpf(String cpf) {
		return prestadorRepository.existsByCpf(cpf);
	}
	
	public List<PrestadorModel> findAll() {
		return prestadorRepository.findAll();
	}
	
	public Optional<PrestadorModel> findById(Long id) {
		return prestadorRepository.findById(id);
	}
	
	@Transactional
	public void delete(PrestadorModel prestadorModel) {
		prestadorRepository.delete(prestadorModel);
	}
}
