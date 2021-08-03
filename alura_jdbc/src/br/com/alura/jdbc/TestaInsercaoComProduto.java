package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Produto;

/**
 * @author Rafaell Estevam Essa classe testa a inserção de um produto através do
 *         objeto produto e não mais através de Strings.
 */
public class TestaInsercaoComProduto {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("cômoda", "cômoda vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
				stm.setString(1, produto.getNome());
				stm.setString(2, produto.getDescricao());
				stm.execute();

				try (ResultSet rst = stm.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}
		}

		System.out.println(produto);
	}

}
