package br.com.alura.java2.api;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.*;

import br.com.alura.java2.modelos.Conta;
import br.com.alura.java2.modelos.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {
		ContaPoupanca cp1 = new ContaPoupanca(1, "Jão");
		ContaPoupanca cp2 = new ContaPoupanca(9, "Jaquim");
		ContaPoupanca cp3 = new ContaPoupanca(6, "Mané");
		ContaPoupanca cp4 = new ContaPoupanca(5, "Juca");
		ContaPoupanca cp5 = new ContaPoupanca(3, "Saca");
		ContaPoupanca cp6 = new ContaPoupanca(2, "Zeca");
		ContaPoupanca cp7 = new ContaPoupanca(4, "Zica");
		ContaPoupanca cp8 = new ContaPoupanca(7, "Soca");
		ContaPoupanca cp9 = new ContaPoupanca(8, "Chão");
		List<ContaPoupanca> contas = new LinkedList<ContaPoupanca>();
		Random random = new Random();

		contas.add(cp1);
		contas.add(cp2);
		contas.add(cp3);
		contas.add(cp4);
		contas.add(cp5);
		contas.add(cp6);
		contas.add(cp7);
		contas.add(cp8);
		contas.add(cp9);

		for (Conta c : contas) {
			c.deposita(random.nextInt(1000));
			System.out.println(c);
		}
		
		System.out.println(contas);

		Collections.sort(contas);

		for (Conta c : contas)
			System.out.println(c);
//
//		java.util.Collections.shuffle(contas);
//
//		for (Conta c : contas)
//			System.out.println(c);

	}
}
