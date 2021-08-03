package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


import dao.ProdutoDAO;
import model.Produto;

/**
 * @author Rafaell Estevam
 *
 */
public class TesteDao {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Fone de ouvido bluetooth", "Fone de ouvido beats model ferrari black");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			connection.setAutoCommit(false);

			try {
				ProdutoDAO produtoDao = new ProdutoDAO(connection);
				produtoDao.salvar(produto);
				produtoDao.remover(50);
				//List<Produto> lista = produtoDao.listar();
				
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
			}

		}

	}

}
