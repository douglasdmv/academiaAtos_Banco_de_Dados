package Principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos2.Department;
import jpaMapeamentos2.Employee;

public class OneToMany {

	 public static void main(String[] args) 
	   {
	      EntityManagerFactory emfactory = Persistence.
	      createEntityManagerFactory( "jpaMapeamentos_1_n" );
	      EntityManager entitymanager = emfactory.
	      createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	      //Criando a entidade empregado 1
	      Employee employee1 = new Employee();
	      employee1.setEname("Satish");
	      employee1.setSalary(45000.0);
	      employee1.setDeg("Technical Writer");

	      //Criando a entidade empregado 2
	      Employee employee2 = new Employee();
	      employee2.setEname("Krishna");
	      employee2.setSalary(45000.0);
	      employee2.setDeg("Technical Writer");

	      //Criando a entidade empregado 3
	      Employee employee3 = new Employee();
	      employee3.setEname("Masthanvali");
	      employee3.setSalary(50000.0);
	      employee3.setDeg("Technical Writer");

	      //Armazenando os empregados no bd
	      entitymanager.persist(employee1);
	      entitymanager.persist(employee2);
	      entitymanager.persist(employee3);

	      //Criando a lista de empregados emplist
	      List<Employee> emplist = new ArrayList();
	      emplist.add(employee1);
	      emplist.add(employee2);
	      emplist.add(employee3);

	      //Criando a entidade departamento
	      Department department= new Department();
	      department.setName("Development");
	      department.setEmployeelist(emplist);

	      //Armazena o departamento no bd
	      entitymanager.persist(department);

	      entitymanager.getTransaction().commit(); //Efetiva as transações com o banco
	      entitymanager.close(); //fecha o gerenciador da entidade
	      emfactory.close(); //fecha o gerenciador da fábrica de entidades
	   }
	}