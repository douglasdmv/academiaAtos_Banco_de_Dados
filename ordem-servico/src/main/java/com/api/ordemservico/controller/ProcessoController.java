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

import com.api.ordemservico.dto.ProcessoDto;
import com.api.ordemservico.model.ProcessoModel;
import com.api.ordemservico.service.ProcessoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro-processo")
public class ProcessoController {
	
	final ProcessoService processoService;
	
	public ProcessoController(ProcessoService processoService) {
		this.processoService = processoService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveProcesso(@RequestBody @Valid ProcessoDto processoDto) {
		if(processoService.existsByProcesso(processoDto.getProcesso())) {
			Logger.error("O processo já está registrado.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O processo já está registrado.");
		}
		
		var processoModel = new ProcessoModel();
		BeanUtils.copyProperties(processoDto, processoModel);
		Logger.info("Cadastro realizado corretamente!");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(processoService.save(processoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ProcessoModel>> getAllProcessos() {
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(processoService.findAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProcesso(@PathVariable(value = "id") Long id) {
		Optional<ProcessoModel> processoModelOptional = processoService.findById(id);
		if(!processoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		processoService.delete(processoModelOptional.get());
		Logger.info("Processo deletado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body("Processo deletado com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProcesso(@PathVariable(value = "id") Long id, @RequestBody @Valid ProcessoDto processoDto) {
		Optional<ProcessoModel> processoModelOptional = processoService.findById(id);
		if(!processoModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		
		var processoModel = new ProcessoModel();
		BeanUtils.copyProperties(processoDto, processoModel);
		processoModel.setProcessoId(processoModelOptional.get().getProcessoId());
		Logger.info("Processo atualizado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body(processoService.save(processoModel));
	}
}
