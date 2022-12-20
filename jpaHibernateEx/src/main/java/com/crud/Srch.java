package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Srch {
        
        private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-exemplo");

        private static EntityManager entityManager = entityManagerFactory.createEntityManager();
        
    public void find(){

        Funcionario funcionario = entityManager.find(Funcionario.class, 2);
        
        System.out.println("\n*---------Funcionario Localizado-------------*\n");
        
        System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
    }
}

