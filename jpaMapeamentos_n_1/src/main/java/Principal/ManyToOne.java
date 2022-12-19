package Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos.Department;
import jpaMapeamentos.Employee;

public class ManyToOne {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpaMapeamento_n_1" );
		EntityManager entitymanager = emfactory.createEntityManager();
		
		 entitymanager.getTransaction( ).begin( ); //abrir um conexão para o bd com a entidade criada
		
		//Criando a entidade departamento
        Department department = new Department();
        //department.setId(1); //setar o nome do departamento desenvolvedor
        department.setName("Development"); //setar o nome do departamento desenvolvedor
        //Store Department
        entitymanager.persist(department); //salvar o departamento do bd

        //Criando a entidade do empregado 1
        Employee employee1 = new Employee();
        employee1.setEname("Satish");
        employee1.setSalary(45000.0);
        employee1.setDeg("Technical Writer");
        employee1.setDepartment(department);

        //Criando a entidade do empregado 2
        Employee employee2 = new Employee();
        employee2.setEname("Krishna");
        employee2.setSalary(45000.0);
        employee2.setDeg("Technical Writer");
        employee2.setDepartment(department);

        //Criando a entidade do empregado 3
        Employee employee3 = new Employee();
        employee3.setEname("Masthanvali");
        employee3.setSalary(50000.0);
        employee3.setDeg("Technical Writer");
        employee3.setDepartment(department);

        //Armazenando no bd os empregados 1,2 e 3 
        entitymanager.persist(employee1);
        entitymanager.persist(employee2);
        entitymanager.persist(employee3);
        
        entitymanager.getTransaction().commit();//fechar a conexão com o bd
        entitymanager.close(); //Encerrar o gerenciador da entidade
        emfactory.close(); //fechar a fábrica de entidades
	}

}
