package br.com.elias;

public class Teste {
	
	public static void main(String[] args) {

		String nome = "z";
		
		Thread busca1 = new Thread(new BuscaEmTexto("assinaturas1.txt", nome));
		Thread busca2 = new Thread(new BuscaEmTexto("assinaturas2.txt", nome));
		Thread busca3 = new Thread(new BuscaEmTexto("autores.txt", nome));
		busca1.start();
		busca2.start();
		busca3.start();
	}
}
