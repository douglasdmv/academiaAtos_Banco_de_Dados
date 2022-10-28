package com.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//define a entidade que será a tabela no banco
@Entity
@Table(name = "funcionarios")
public class Funcionario {
    
	//identificação da primary key
    @Id
    //informa que o id será de auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Integer id;

    @Column(name = "Nome_Completo")
    String nomeCompleto;

    @Column(name = "Cargo")
    String cargo;

    @Column(name = "Idade")
    Integer idade;

    public Funcionario(Integer id, String nome, String cargo, Integer idade) {
		super();
		this.id = id;
		this.nomeCompleto = nome;
		this.cargo = cargo;
		this.idade = idade;
	}
    
    public Funcionario () {
		
	}
    
    @Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nomeCompleto + ", cargo=" + cargo + ", idade=" + idade + "]";
	}
    
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
