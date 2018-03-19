package br.com.alura.cursos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestandoListas {

	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revistando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula :: getTempo));
		
		System.out.println(aulas);	
		
//		ArrayList<String> cursos = new ArrayList<>();
//		
//		cursos.add("Java 8: Tire proveito dos novos recursos da linguagem");
//		cursos.add("Apache Camel");
//		cursos.add("Certificacao Java SE 8 Programmer I");
//		
//		System.out.println(cursos);
//		
//		Collections.sort(cursos);
//		
//		System.out.println(cursos);
	}
}
