package com.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "funcionarios")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Nome_Completo")
    private String nomeCompleto;

    @Column(name = "Cargo")
    private String cargo;

    @Column(name = "Idade")
    private Integer idade;

    /*-----(GET)--------------(SET)------*/
    /*----------------ID----------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*---------------Nome----------------*/

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /*---------------Cargo----------------*/

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /*---------------Idade----------------*/

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
