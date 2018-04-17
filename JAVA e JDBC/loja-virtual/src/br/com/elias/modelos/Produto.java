package br.com.elias.modelos;

public class Produto {

	int id;
	String nome, descricao;
	
	public Produto() { this(0, null, null); }

	public Produto(String nome, String descricao) { this(0, nome, descricao); }	
	
	public Produto(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() { return nome; }
	public String getDescricao() { return descricao; }
	public void setId(int id) { this.id = id; }
	public int getId() { return id; }

	@Override
	public String toString() { return "Produto [id: " + id + ", nome: " + nome + ", descricao: " + descricao + "]"; }
}
