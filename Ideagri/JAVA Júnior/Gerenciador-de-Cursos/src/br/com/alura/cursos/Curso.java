package br.com.alura.cursos;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	private String     nome;
	private String     instrutor;
	private List<Aula> aulas = new LinkedList<>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> mapaAlunos = new HashMap<>();
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public void matricula(Aluno aluno){
		this.alunos.add(aluno);
		this.mapaAlunos.put(aluno.getMatricula(), aluno);
	}
	
	public Aluno buscaMatriculado(int matricula) {
		if(!mapaAlunos.containsKey(matricula))
			throw new NoSuchElementException("N�o existe essa matr�cula!");
		return this.mapaAlunos.get(matricula);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
		
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public List<Aula> getAulas(){
		return Collections.unmodifiableList(aulas);
	}
	
	public int getTempoTotal() {
		return aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		return "[" + nome + " Instrutor: " + instrutor +", tempo total: " + getTempoTotal() + ", aulas: " + aulas + "]";
	}
	
	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
}
