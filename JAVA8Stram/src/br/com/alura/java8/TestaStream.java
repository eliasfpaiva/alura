package br.com.alura.java8;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

public class TestaStream {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		List<Curso> lista = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		System.out.println(lista);
		
//		cursos.stream().mapToDouble(Curso::getAlunos).average().ifPresent(System.out::println);
		
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 50).findFirst().ifPresent(System.out::println);
		
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 50)
//		   .map(Curso::getAlunos)
//		   .forEach(System.out::println);
//		
//		cursos.stream()
//		   .filter(c -> c.getAlunos() > 50)
//		   .map(c -> c.getAlunos())
//		   .forEach(x -> System.out.println(x));
		
//		Stream<String> nomes = cursos.stream().map(Curso::getNome);
//		
//		nomes.forEach(System.out::println);
		
//		cursos.stream().filter(c -> c.getAlunos() >50).forEach(c -> System.out.println(c.getNome()));
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
//		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
//		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		
//		cursos.sort(new Comparator<Curso>() {
//
//			@Override
//			public int compare(Curso c1, Curso c2) {
//				return c1.getAlunos() - c2.getAlunos();
//			}
//		});
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
	}
}
