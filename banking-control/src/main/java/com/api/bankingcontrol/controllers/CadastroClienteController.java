package com.api.bankingcontrol.controllers;

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

import com.api.bankingcontrol.dtos.CadastroClienteDto;
import com.api.bankingcontrol.models.CadastroClienteModel;
import com.api.bankingcontrol.services.CadastroClienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro-cliente")
public class CadastroClienteController {
	
	final CadastroClienteService cadastroClienteService;

	public CadastroClienteController(CadastroClienteService cadastroClienteService) {
		this.cadastroClienteService = cadastroClienteService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCadastroCliente(@RequestBody @Valid CadastroClienteDto cadastroClienteDto) {
		if(cadastroClienteService.existsByCpf(cadastroClienteDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O número de CPF já está registrado.");
		}
		
		var cadastroClienteModel = new CadastroClienteModel();
		BeanUtils.copyProperties(cadastroClienteDto, cadastroClienteModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroClienteService.save(cadastroClienteModel));
	}
	
	@GetMapping
	public ResponseEntity<List<CadastroClienteModel>> getAllCadastroClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCadastroCliente(@PathVariable(value = "id") Integer id) {
		Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
		if (!cadastroClienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCadastroCliente(@PathVariable(value = "id") Integer id) {
		Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
		if (!cadastroClienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado.");
		}
		cadastroClienteService.delete(cadastroClienteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCadastroCliente(@PathVariable(value = "id") Integer id, @RequestBody @Valid CadastroClienteDto cadastroClienteDto) {
		Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
		if (!cadastroClienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado.");
		}
		
		var cadastroClienteModel = new CadastroClienteModel();
		BeanUtils.copyProperties(cadastroClienteDto, cadastroClienteModel);
		cadastroClienteModel.setId(cadastroClienteModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteService.save(cadastroClienteModel));
	}
}
