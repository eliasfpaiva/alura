package br.com.alura.cursos;

import java.util.List;
import java.util.Random;

public class TestaCurso {

	public static void main(String[] args) {

		Curso curso = new Curso("Testando cursos", "Hipster");
		Random r = new Random();

		List<Aula> aulas = curso.getAulas();

		System.out.println(aulas);

		for(int i=1; i<=5; i++)
			curso.adiciona(new Aula(i + "ª aula", r.nextInt(30)));

		aulas = curso.getAulas();

		System.out.println(aulas);

		System.out.println(curso.getAulas().get(aulas.size()/2));
	}
}
