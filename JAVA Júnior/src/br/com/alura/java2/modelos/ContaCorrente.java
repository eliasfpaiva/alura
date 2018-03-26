package br.com.alura.java2.modelos;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente() {	}
	
	public ContaCorrente(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 2;
    }

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
}
