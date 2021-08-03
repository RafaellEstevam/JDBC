package br.com.alura.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaRemocao {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Integer id = 46;

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE id=?")) {
				stm.setInt(1, id);
				stm.execute();

				Integer linhasRemovidas = stm.getUpdateCount();
				System.out.println("Linhas removidas: " + linhasRemovidas);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}

		}
	}

}
