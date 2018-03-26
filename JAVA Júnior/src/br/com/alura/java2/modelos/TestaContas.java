package br.com.alura.java2.modelos;

import java.util.HashSet;

public class TestaContas {

	public static void main(String[] args) {

		HashSet<Conta> contas = new HashSet<>();

		for (int i = 1; i <= 20; i = i + 2) {
			contas.add(new ContaCorrente(i, "Teste: " + i));
			contas.add(new ContaCorrente(i + 1, "Teste: " + (i + 1)));
		}

		int q = contas.size();

		System.out.println(q);

		System.out.println(contas);

	}
}
