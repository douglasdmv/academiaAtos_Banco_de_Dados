package com.api.ordemservico.controller;

import java.time.LocalDate;
import java.time.ZoneId;
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

import com.api.ordemservico.dto.OrdemServicoDto;
import com.api.ordemservico.model.OrdemServicoModel;
import com.api.ordemservico.service.OrdemServicoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro-ordem-servico")
public class OrdemServicoController {
	final OrdemServicoService ordemServicoService;
	
	public OrdemServicoController(OrdemServicoService ordemServicoService) {
		this.ordemServicoService = ordemServicoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveOrdemServico(@RequestBody @Valid OrdemServicoDto ordemServicoDto) {
		
		var ordemServicoModel = new OrdemServicoModel();
		BeanUtils.copyProperties(ordemServicoDto, ordemServicoModel);
		ordemServicoModel.setDataEmissão(LocalDate.now(ZoneId.of("UTC")));
		Logger.info("Cadastro realizado corretamente!");
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoService.save(ordemServicoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoModel>> getAllOrdemServicos() {
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(ordemServicoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneOrdemServico(@PathVariable(value = "id") Long id) {
		Optional<OrdemServicoModel> ordemServicoModelOptional = ordemServicoService.findById(id);
		if(!ordemServicoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(ordemServicoModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOrdemServico(@PathVariable(value = "id") Long id) {
		Optional<OrdemServicoModel> ordemServicoModelOptional = ordemServicoService.findById(id);
		if(!ordemServicoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		ordemServicoService.delete(ordemServicoModelOptional.get());
		Logger.info("Produto deletado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateOrdemServico(@PathVariable(value = "id") Long id, @RequestBody @Valid OrdemServicoDto ordemServicoDto) {
		Optional<OrdemServicoModel> ordemServicoModelOptional = ordemServicoService.findById(id);
		if(!ordemServicoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		
		var ordemServicoModel = new OrdemServicoModel();
		BeanUtils.copyProperties(ordemServicoDto, ordemServicoModel);
		ordemServicoModel.setDataEmissão(LocalDate.now(ZoneId.of("UTC")));
		ordemServicoModel.setIdOrdem(ordemServicoModelOptional.get().getIdOrdem());
		Logger.info("Produto atualizado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body(ordemServicoService.save(ordemServicoModel));
	}
}
