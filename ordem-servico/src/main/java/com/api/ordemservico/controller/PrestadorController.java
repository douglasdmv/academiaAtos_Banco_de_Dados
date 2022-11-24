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

import com.api.ordemservico.dto.PrestadorDto;
import com.api.ordemservico.model.PrestadorModel;
import com.api.ordemservico.service.PrestadorService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro-prestador")
public class PrestadorController {
	
	final PrestadorService prestadorService;
	
	public PrestadorController(PrestadorService prestadorService) {
		this.prestadorService = prestadorService;
	}
	
	@PostMapping
	public ResponseEntity<Object> savePrestador(@RequestBody @Valid PrestadorDto prestadorDto) {
		if(prestadorService.existsByCpf(prestadorDto.getCpf())) {
			Logger.error("O número de CPF já está registrado.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O número de CPF já está registrado.");
		}
		
		var prestadorModel = new PrestadorModel();
		BeanUtils.copyProperties(prestadorDto, prestadorModel);
		Logger.info("Cadastro realizado corretamente!");

		return ResponseEntity.status(HttpStatus.CREATED).body(prestadorService.save(prestadorModel));
	}
	
	@GetMapping
	public ResponseEntity<List<PrestadorModel>> getAllPrestadores() {
		Logger.info("Consulta realizada com sucesso!");
		return ResponseEntity.status(HttpStatus.OK).body(prestadorService.findAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePrestador(@PathVariable(value = "id") Long id) {
		Optional<PrestadorModel> prestadorModelOptional = prestadorService.findById(id);
		if(!prestadorModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		prestadorService.delete(prestadorModelOptional.get());
		Logger.info("Prestador deletado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body("Prestador deletado com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePrestador(@PathVariable(value = "id") Long id, @RequestBody @Valid PrestadorDto prestadorDto) {
		Optional<PrestadorModel> prestadorModelOptional = prestadorService.findById(id);
		if(!prestadorModelOptional.isPresent()) {
			Logger.error("Cadastro não encontrado!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado!");
		}
		
		var prestadorModel = new PrestadorModel();
		BeanUtils.copyProperties(prestadorDto, prestadorModel);
		prestadorModel.setPrestadorId(prestadorModelOptional.get().getPrestadorId());
		Logger.info("Prestador atualizado com sucesso.");
		return ResponseEntity.status(HttpStatus.OK).body(prestadorService.save(prestadorModel));
	}
}
