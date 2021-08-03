package br.com.alura.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaListagem {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM PRODUTO")) {
				stm.execute();

				try (ResultSet rst = stm.getResultSet()) {
					while (rst.next()) {
						Integer id = rst.getInt("id");
						String nome = rst.getString("nome");
						String descricao = rst.getString("descricao");

						System.out.println(id + " " + nome + " " + descricao);
					}
				}
			}

		}
	}

}
