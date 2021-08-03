package br.com.alura.jdbc;

import java.sql.SQLException;

/**
 * @author Rafaell Estevam
 *
 */
public class TestePoolDeConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			factory.recuperarConexao();

			System.out.println("conexão de número: " + (i + 1));
		}

	}

}
