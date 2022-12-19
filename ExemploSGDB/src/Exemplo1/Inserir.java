package Exemplo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserir {

	public static void main(String[] args) {
		final String db_url = "jdbc:mysql://localhost:3306/reuniao"; //caminho de acesso ao banco de dados
		final String db_query = "INSERT INTO pessoa (nome, email, cargo) values ('Alberto Santos', 'santos@yahoo.com', 'Professor')"; //query a ser executada pelo banco de dados
		final String db_user = "root"; //usuário do SGDB
		final String db_password = ""; //senha do SGDB
		// int resultSetRows = 0;
		System.out.println("Iniciando conexão ao DB");
		try { 
			Connection c = DriverManager.getConnection(db_url, db_user, db_password);
			System.out.println("Conectado ao MySql");
			Statement statement = c.createStatement();
			int linhas = statement.executeUpdate(db_query);
			System.out.println("A query afetou "+linhas);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}

