package com.api.ordemservico.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinylog.Logger;

import com.api.ordemservico.dto.ProdutoDto;
import com.api.ordemservico.model.ProdutoModel;
import com.api.ordemservico.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro-produto")
public class ProdutoController {
	
	final ProdutoService produtoService;
	
	public ProdutoController (ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		
		var produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(produtoDto, produtoModel);
		
		Logger.info("Cadastro realizado corretamente!");
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneProduto(@PathVariable(value = "id")Long id) {
		Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
		if(!produtoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(produtoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") Long id) {
		Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
		if(!produtoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		produtoService.delete(produtoModelOptional.get());
		Logger.info("Produto deletado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") Long id, @RequestBody @Valid ProdutoDto produtoDto) {
		Optional<ProdutoModel> produtoModelOptional = produtoService.findById(id);
		if(!produtoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		
		var produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(produtoDto, produtoModel);
		produtoModel.setProdutoId(produtoModelOptional.get().getProdutoId());
		Logger.info("Produto atualizado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));
	}
}
