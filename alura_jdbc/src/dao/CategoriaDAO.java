package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

/**
 * @author Rafaell Estevam
 *
 */
public class CategoriaDAO {

	Connection connection;

	public CategoriaDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void inserir(Categoria categoria) throws SQLException {
		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO CATEGORIA (nome) VALUES (?)")) {
			stm.setString(1, categoria.getNome());
			stm.execute();
		}
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> listaCategorias = new ArrayList<Categoria>();

		try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM CATEGORIA")) {
			stm.execute();

			try (ResultSet rst = stm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

					listaCategorias.add(categoria);
				}
			}
		}

		return listaCategorias;
	}

}
