package model;

/**
 * @author Rafaell Estevam
 *
 */
public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Categoria categoria;

	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return id + " " + nome + " " + descricao + " " + categoria.getId() + " " + categoria.getNome();
	}

}
