package br.com.alura.maven;

public class Produto {

	private final String nome;
	private final double preco;
	
    public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}	

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

	public double getPrecoComImposto() {
		return this.preco * 1.1;
	}
}
