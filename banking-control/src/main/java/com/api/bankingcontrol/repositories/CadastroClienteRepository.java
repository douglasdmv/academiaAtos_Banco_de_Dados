package com.api.bankingcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bankingcontrol.models.CadastroClienteModel;

@Repository
public interface CadastroClienteRepository extends JpaRepository<CadastroClienteModel, Integer> {
	
	boolean existsByCpf(String cpf);
}
