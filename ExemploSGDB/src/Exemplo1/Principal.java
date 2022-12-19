package Exemplo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		final String db_url = "jdbc:mysql://localhost:3306/reuniao"; //caminho de acesso ao banco de dados
		final String db_query = "SELECT * FROM pessoa"; //query a ser executada pelo banco de dados
		final String db_user = "root"; //usuário do SGDB
		final String db_password = ""; //senha do SGDB
		// int resultSetRows = 0;
		System.out.println("Iniciando conexão ao DB");
		try (Connection c = DriverManager.getConnection(db_url, db_user, db_password);
				Statement statement = c.createStatement();
				ResultSet resultSet = statement.executeQuery(db_query);) {
			System.out.println("Conectado ao MySql");
			
			while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" \t"+resultSet.getString(3)+" \t"+resultSet.getString(4));
                System.out.println();
            }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}
