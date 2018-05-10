package br.com.elias;

public class Produto {

	private int    codigo;
	private String nome;
	private String fornecedor;
	private String descricao;
	private double preco;

	public Produto(int codigo, String nome, String fornecedor, String descricao, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.preco = preco;
	}

	public void   setCodigo(int codigo)            { this.codigo = codigo; }
	public void   setNome(String nome)             { this.nome = nome; }
	public void   setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
	public void   setDescricao(String descricao)   { this.descricao = descricao; }
	public void   setPreco(double preco)           { this.preco = preco; }
	public int    getCodigo()                      { return codigo; }
	public String getNome()                        { return nome; }
	public String getFornecedor()                  { return fornecedor; }
	public String getDescricao()                   { return descricao; }
	public double getPreco()                       { return preco; }

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", fornecedor=" + fornecedor + ", descricao="
				+ descricao + ", preco=" + preco + "]";
	}
}
