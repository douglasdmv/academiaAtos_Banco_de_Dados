package com.api.ordemservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ordemservico.model.PrestadorModel;

@Repository
public interface PrestadorRepository extends JpaRepository<PrestadorModel, Long>{
	
	boolean existsByCpf(String cpf);
}
