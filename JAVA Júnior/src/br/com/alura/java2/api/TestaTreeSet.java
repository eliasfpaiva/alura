package br.com.alura.java2.api;
import java.util.TreeSet;

public class TestaTreeSet {

	public static void main(String[] args) {

		TreeSet<Integer> numeros = new TreeSet<>();

		for (int i = 1; i <= 1000; i++)
			numeros.add(i);
		
		numeros = (TreeSet<Integer>) numeros.descendingSet();
		
		System.out.println(numeros.descendingSet());
	}

}
