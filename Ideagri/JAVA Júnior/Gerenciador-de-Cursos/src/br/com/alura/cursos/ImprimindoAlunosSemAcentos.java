package br.com.alura.cursos;

import java.util.HashSet;
import java.util.Set;

public class ImprimindoAlunosSemAcentos {

	public static void main(String[] args) {
		
		Set<String> alunos = new HashSet<>();
		
		alunos.add("Paulo");
		alunos.add("Alberto");
		alunos.add("Pedro");
		alunos.add("Nico");
		
		System.out.println(alunos.size());
		
		System.out.println("Paulo foi adicionado ao set? " + alunos.add("Paulo"));
		
		System.out.println(alunos.size());
		
//		for (String aluno : alunos) {
//			System.out.println(aluno);
//		}
		
		alunos.forEach(aluno ->{
			System.out.println(aluno);
			
		});
	}
}
