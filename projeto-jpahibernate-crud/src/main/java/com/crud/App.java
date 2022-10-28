package com.crud;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
	//fabricação e criação da entidade
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("crud");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
    public static void main( String[] args ) throws InterruptedException
    {
        String i;
        char operacao;

        Scanner leitor = new Scanner(System.in);

        System.out.println("\n*----------------CRUD - v1.0----------------*");
        System.out.println("Inicializando...");
        Thread.sleep(1500);

        do{
        System.out.println("\nEscolha qual procedimento voce gostaria de realizar:\n");
        
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Modificar funcionário");
        System.out.println("3 - Deletar funcionário");
        System.out.println("4 - Localizar funcionário");

        i = leitor.nextLine();
        
        } while (!(i.contains("1") || i.contains("2") || i.contains("3") || i.contains("4")));

        operacao = i.charAt(0);
        
        switch (operacao) {

            case '1': {

                // INSERT
            	String nome, cargo;
            	Integer idade;
            	System.out.println("Digite o nome do funcionário: ");
        		nome = leitor.nextLine();
        		System.out.println("Digite o cargo do funcionário: ");
        		cargo = leitor.nextLine();
        		System.out.println("Digite a idade do funcionário: ");
        		idade = leitor.nextInt();
        		leitor.nextLine();
            	Funcionario funcionario = new Funcionario(null,nome, cargo, idade);

                entityManager.getTransaction().begin();
                entityManager.persist(funcionario);
                entityManager.getTransaction().commit();
                
                System.out.println("\n*----------FUNCIONARIO CRIADO---------*\n");
                System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
                break;
            }

            case '2': {
                
                // MODIFY
            	Integer id, idade;
            	String nome, cargo;
            	System.out.println("Digite o id do funcionário que deseja modificar: ");
        		id = leitor.nextInt();
        		leitor.nextLine();
        		
        		Funcionario funcionario = entityManager.find(Funcionario.class, id);
        		
        		System.out.println("Digite o novo nome do funcionário: ");
        		nome = leitor.nextLine();
        		System.out.println("Digite o novo cargo do funcionário: ");
        		cargo = leitor.nextLine();
        		System.out.println("Digite a nova idade do funcionário: ");
        		idade = leitor.nextInt();
        		leitor.nextLine();
                
                funcionario.setNomeCompleto(nome);
                funcionario.setCargo(cargo);
                funcionario.setIdade(idade);

                entityManager.getTransaction().begin();
                entityManager.merge(funcionario);
                entityManager.getTransaction().commit();
                
                System.out.println("\n------*FUNCIONARIO MODIFICADO*------\n");
                System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
                break;
            }

            case '3': {

                // DELETE
            	Integer id;
            	System.out.println("Digite o id do funcionário que deseja deletar: ");
        		id = leitor.nextInt();
        		leitor.nextLine();
                Funcionario funcionario = entityManager.find(Funcionario.class, id);
                
                entityManager.getTransaction().begin();
                entityManager.remove(funcionario);
                entityManager.getTransaction().commit();
                
                System.out.println("\n------*FUNCIONARIO DELETADO*------\n");
                System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " +funcionario.getIdade());
                break;
            }

            case '4': {

            	//FIND
            	Integer id;
            	System.out.println("Digite o id do funcionário que deseja localizar: ");
        		id = leitor.nextInt();
        		leitor.nextLine();
                Funcionario funcionario = entityManager.find(Funcionario.class, id);
                
                System.out.println("\n*---------FUNCIONARIO LOCALIZADO-------------*\n");
                
                System.out.println("Nome Completo: " + funcionario.getNomeCompleto() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade());
                break;
            }
        }
        
        leitor.close();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("\nExecutado com sucesso!\n");
    }
}
