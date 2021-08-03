package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

/**
 * @author Rafaell Estevam
 *
 */
public class TesteDaoListagemComJoin {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO pd = new ProdutoDAO(connection);

			List<Produto> listaProdutos = pd.listar();

			for (Produto produto : listaProdutos) {
				System.out.println(produto);
			}

		}

	}
}
