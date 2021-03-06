package br.com.alura.cursos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestaMapas {

	public static void main(String[] args) {
		
		Curso curso = new Curso("Curso de mapas", "Paulo Silveira");
		System.out.println(curso);
		
		curso.matricula(new Aluno("Leonardo Cordeiro", 21));
		curso.matricula(new Aluno(27, "Fabio Pimentel"));
		curso.matricula(new Aluno(19, "Silvio Mattos"));
		curso.matricula(new Aluno("Romulo Henrique", 23));

//		for (Aluno aluno : curso.getAlunos()) {
//			System.out.println(curso.buscaMatriculado(aluno.getMatricula()));
//			System.out.println(aluno);
//		}
		
		Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);

//        nomesParaIdade.keySet().forEach(key -> {System.out.println(key);});
        
        for (String chave : nomesParaIdade.keySet()) {
        	System.out.println("Chave: " + chave);			
		}
//        
//        nomesParaIdade.values().forEach(value -> {System.out.println(value);});
        
        for (int valor : nomesParaIdade.values()) {
			System.out.println("Valor: " + valor);
		}
//        
//        nomesParaIdade.entrySet().forEach(entry -> {System.out.println("Chave: " + entry.getKey()); 
//        System.out.println("Valor: " + entry.getValue());});
        
        for (Entry<String, Integer> associacao : nomesParaIdade.entrySet()) {
			System.out.println("Chave: " + associacao.getKey() + "\nValor: " + associacao.getValue());
		}
//        
//		for (Integer key : pessoas.keySet()) {
//			System.out.println(pessoas.get(key));
//		}
//        
//        pessoas.keySet().forEach(idade -> {
//            System.out.println(pessoas.get(idade));
//        });

	}
}
