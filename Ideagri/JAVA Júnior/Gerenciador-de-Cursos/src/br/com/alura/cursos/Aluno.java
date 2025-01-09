package br.com.alura.cursos;

public class Aluno {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int matricula) {
		if(nome == null) {
			throw new NullPointerException("Nome não pode ser nulo, coleguinha!");
		}
		this.nome = nome;
		this.numeroMatricula = matricula;
	}
	
	public Aluno(int matricula, String nome) {
		if(nome == null) {
			throw new NullPointerException("Nome não pode ser nulo, coleguinha!");
		}
		this.nome = nome;
		this.numeroMatricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public int getMatricula() {
		return this.numeroMatricula;
	}

	@Override
	public String toString() {
		return "[" + this.nome + ", matricula: " + this.numeroMatricula + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		Aluno outroAluno = (Aluno) obj;
//		return this.nome.equals(outroAluno.nome);
//	}
//	
//	@Override
//	public int hashCode() {
//		return this.nome.hashCode();
//	}
}
