package br.com.alura.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaInsercao{

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		String nome = "Xbox one";
		String descricao = "Xbox one X - 1TB Edição Star Wars";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) { //abrindo conexão

			connection.setAutoCommit(false);//abrindo transação

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {//abrindo declaração
				stm.setString(1, nome);
				stm.setString(2, descricao);
				stm.execute();

				try (ResultSet rst = stm.getGeneratedKeys()) { //abrindo declaração para pegar resultado
					while (rst.next()) {
						Integer id = rst.getInt(1);
						System.out.println("Id gerado: " + id);
					}
				}

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}

		}
	}

}
