package com.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Mod {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-exemplo");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public void modifyFuncionario(){

        Funcionario funcionario = new Funcionario();

        funcionario.setId(2);
        funcionario.setNomeCompleto("Amanda Komman");
        funcionario.setCargo("Analista de dados");
        funcionario.setIdade(31);

        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.getTransaction().commit();
        

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("\n------*FUNCIONARIO MODIFICADO*------\n");
        System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
    }
}