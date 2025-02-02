package br.com.alura.cursos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {

		Collection<Integer> numeros = new ArrayList<Integer>();

		long inicio = System.currentTimeMillis();

		for (int i = 0; i <= 100000; i++)
			numeros.add(i);

		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto inser��o ArrayList: " + tempoDeExecucao);
		
		inicio = System.currentTimeMillis();

		for (Integer numero : numeros)
			numeros.contains(numero);

		fim = System.currentTimeMillis();

		tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto busca ArrayList: " + tempoDeExecucao);

		numeros = new HashSet<>();

		inicio = System.currentTimeMillis();

		for (int i = 0; i <= 100000; i++)
			numeros.add(i);

		fim = System.currentTimeMillis();

		tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto inser��o HashSet: " + tempoDeExecucao);

		inicio = System.currentTimeMillis();
		
		for (Integer numero : numeros)
			numeros.contains(numero);

		fim = System.currentTimeMillis();

		tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto busca HashSet: " + tempoDeExecucao);
	}
}
