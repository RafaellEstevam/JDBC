package model;

/**
 * @author Rafaell Estevam
 *
 */
public class Categoria {

	private Integer id;
	private String nome;

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return id + " " + nome;
	}

}
