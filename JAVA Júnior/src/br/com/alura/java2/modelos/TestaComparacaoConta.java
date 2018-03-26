package br.com.alura.java2.modelos;

public class TestaComparacaoConta {
	
	public static void main(String[] args) {
		Conta cp = new ContaPoupanca(10, "Zé");
		Conta cc = new ContaCorrente(10, "Zé");
		
		System.out.println(cp == cc);
		System.out.println(cp.equals(cc));
	}
}
