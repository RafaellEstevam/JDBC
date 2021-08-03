package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

/**
 * @author Rafaell Estevam
 *
 */
public class TestaInsercaoEListagemCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

//			categoriaDAO.inserir(new Categoria("Smartphones e Tablets"));

			List<Categoria> listaCategorias = categoriaDAO.listar();

			listaCategorias.stream().forEach(ct -> System.out.println(ct.getId() +" "+ct.getNome()));

		}

	}

}
