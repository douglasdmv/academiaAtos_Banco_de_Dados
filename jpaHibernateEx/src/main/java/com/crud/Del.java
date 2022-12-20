package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Del {
    
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-exemplo");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void deleteFuncionario(){

        Funcionario funcionario = entityManager.find(Funcionario.class, 2);
        
        entityManager.getTransaction().begin();
        entityManager.remove(funcionario);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        
        System.out.println("\n------*FUNCIONARIO DELETADO*------\n");
        System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " +funcionario.getIdade());
    }
}
