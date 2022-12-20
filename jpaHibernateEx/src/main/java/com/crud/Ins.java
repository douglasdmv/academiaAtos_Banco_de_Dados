package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ins {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-exemplo");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public void insertFuncionario(){

        Funcionario funcionario = new Funcionario();
        
        funcionario.setNomeCompleto("Fahim Scallander");
        funcionario.setCargo("Developer");
        funcionario.setIdade(25);

        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("\n*----------FUNCIONARIO CRIADO---------*\n");
        System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
    }
}

