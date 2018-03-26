package br.com.alura.java2.modelos;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	public ContaPoupanca() { }
	
	public ContaPoupanca(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 3;
    }

    public void deposita(double valor) {
        this.saldo += valor - 0.10;
    }

	@Override
	public int compareTo(ContaPoupanca o) {
		return this.nome.compareTo(o.nome);
	}
}
