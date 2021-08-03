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
public class TesteInsercaoVariosProdutos {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("Jaqueta masculina","Jaqueta masculina de couro", stm);
				
				adicionarVariavel("Fone de ouvido", " Fone de ouvido Gamer, Luz LED - Azul", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}

		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("id gerado: " + id);
			}
		}

	}

}
