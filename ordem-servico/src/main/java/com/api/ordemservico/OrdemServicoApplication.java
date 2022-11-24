package com.api.ordemservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrdemServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdemServicoApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "API Inicializada";
	}
}
