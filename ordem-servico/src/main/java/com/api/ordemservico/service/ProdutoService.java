package com.api.ordemservico.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.ordemservico.model.ProdutoModel;
import com.api.ordemservico.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional
	public ProdutoModel save(ProdutoModel produtoModel) {
		return produtoRepository.save(produtoModel);
	}
	
	public List<ProdutoModel> findAll() {
		return produtoRepository.findAll();
	}
	
	public Optional<ProdutoModel> findById(Long id) {
		return produtoRepository.findById(id);
	}
	
	@Transactional
	public void delete(ProdutoModel produtoModel) {
		produtoRepository.delete(produtoModel);
	}
}
