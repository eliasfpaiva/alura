package br.com.alura.cursos;

public class TestaCurso3 {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Testando cursos", "Hipster");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com cole��es", 22));
        
        javaColecoes.matricula(new Aluno("J�o", 12346));
        javaColecoes.matricula(new Aluno("Man�", 456789));
        javaColecoes.matricula(new Aluno("z�", 789123));
        
//        System.out.println(javaColecoes.getAlunos());
        
        javaColecoes.getAlunos().forEach(aluno -> {
        	System.out.println(aluno);
        });
	}
}
