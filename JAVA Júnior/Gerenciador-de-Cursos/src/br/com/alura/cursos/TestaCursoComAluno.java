package br.com.alura.cursos;

import java.util.Set;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do JAVA", "Paulo Silveira");
		
		Aluno a1 = new Aluno("Rodrigo Turine", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 34672);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		Aluno a4 = new Aluno("Jaquim Coves", 98453);
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		
//		javaColecoes.matricula(a4);
		
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println(javaColecoes.estaMatriculado(a4));
	}
}
