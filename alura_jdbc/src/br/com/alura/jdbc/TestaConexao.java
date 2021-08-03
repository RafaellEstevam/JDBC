package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaConexao {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			System.out.println("fechando a conexão!");
		}

	}
}
