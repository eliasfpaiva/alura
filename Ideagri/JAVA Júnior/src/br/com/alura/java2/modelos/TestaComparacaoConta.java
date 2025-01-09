package br.com.alura.java2.modelos;

public class TestaComparacaoConta {
	
	public static void main(String[] args) {
		Conta cp = new ContaPoupanca(10, "Z�");
		Conta cc = new ContaCorrente(10, "Z�");
		
		System.out.println(cp == cc);
		System.out.println(cp.equals(cc));
	}
}
