package br.com.alura.cursos;

public class Recibo {

	private String nome;
	private double valor;
	
	public Recibo(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
	
}
