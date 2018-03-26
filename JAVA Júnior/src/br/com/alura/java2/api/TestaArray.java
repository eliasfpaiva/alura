package br.com.alura.java2.api;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class TestaArray {

	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<>();
		
		for(int i = 1; i <= 1000; i++)
			numeros.add(i);
		
		System.out.println(numeros);
		
		Collections.reverse(numeros);
		
		System.out.println(numeros);
//
//		List<Integer> teste = new ArrayList<Integer>();
//		long inicio = System.currentTimeMillis();
//		
//		for(int i = 0; i < 30000; i++)
//			teste.add(0, i);
//		
//		long fim = System.currentTimeMillis();
//		long tempo = fim - inicio;
//		System.out.println("Tempo: " + tempo);
//		
//		teste = new LinkedList<Integer>();
//		
//		inicio = System.currentTimeMillis();
//		
//		for(int i = 0; i < 30000; i++)
//			teste.add(0, i);
//		
//		fim = System.currentTimeMillis();
//		tempo = fim - inicio;
//		System.out.println("Tempo: " + tempo);
//		
	}
}
