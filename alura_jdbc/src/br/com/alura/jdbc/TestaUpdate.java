package br.com.alura.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaUpdate {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Integer id = 2;
		String nome = "Geladeira";
		String descricao = "Geladeira azul EletroLux";

		ConnectionFactory factory = new ConnectionFactory();

		try (Connection connection = factory.recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection
					.prepareStatement("UPDATE PRODUTO SET nome=?, descricao=? WHERE id=?")) {
				stm.setString(1, nome);
				stm.setString(2, descricao);
				stm.setInt(3, id);
				stm.execute();

				connection.commit();

				System.out.println("Alteração realizada com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}

		}
	}

}
