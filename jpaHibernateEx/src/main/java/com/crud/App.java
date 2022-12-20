package com.crud;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Ins insert = new Ins();
        Mod modify = new Mod();
        Del delete = new Del();
        Srch search = new Srch();

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

        i = leitor.next();

        } while (!(i.contains("1") || i.contains("2") || i.contains("3") || i.contains("4")));

        operacao = i.charAt(0);
        
        switch (operacao) {

            case '1': {

                // INSERT
                insert.insertFuncionario();
                break;
            }

            case '2': {
                
                // MODIFY
                modify.modifyFuncionario();
                break;
            }

            case '3': {

                // DELETE
                delete.deleteFuncionario();
                break;
            }

            case '4': {

                search.find();
                break;
            }
        }

        System.out.println("\nExecutado com sucesso!\n");

        leitor.close();

    }
}
