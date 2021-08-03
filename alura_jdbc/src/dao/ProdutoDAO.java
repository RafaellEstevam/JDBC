package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import model.Categoria;
import model.Produto;

/**
 * @author Rafaell Estevam
 *
 */
public class ProdutoDAO {

	Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.execute();

			System.out.println("Novo produto cadastrado!");
			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}

		}

	}

	public void remover(Integer id) throws SQLException {

		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE id=?")) {
			stm.setInt(1, id);
			stm.execute();

			Integer qtdRemovida = stm.getUpdateCount();
			System.out.println(qtdRemovida + " produto(s) removido(s) com sucesso!");

		}
	}

	public void atualizar(Integer id, Produto produto) throws SQLException {

		try (PreparedStatement stm = connection.prepareStatement("UPDATE PRODUTO SET nome=?,descricao=? WHERE id=?")) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setInt(3, id);
			stm.execute();

			System.out.println("Alteração realizada com sucesso!");
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> listaProdutos = new ArrayList<Produto>();

		try (PreparedStatement stm = connection.prepareStatement(
				"SELECT pr.id, pr.nome AS nome_produto, pr.descricao, pr.categoria_id, cat.nome AS nome_categoria FROM PRODUTO pr JOIN CATEGORIA cat ON pr.categoria_id=cat.id;")) {
			stm.execute();

			try (ResultSet rst = stm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(4), rst.getString(5));
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), categoria);

					listaProdutos.add(produto);
				}
			}

		}
		return listaProdutos;
	}

}
