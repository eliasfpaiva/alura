package br.com.alura.java2.api;


public class Palavra {

	public void imprimeLetraPorLetra(String texto) {
		StringBuilder palavra = new StringBuilder(texto);
		System.out.println(palavra.reverse());
	}

	public void inverteFrase(String frase) {

		String[] palavras = frase.split(" ");

		for (int i = palavras.length - 1; i >= 0; i--) {
			System.out.print(palavras[i] + " ");
		}
	}
	
	public int converteParaNumero(String palavra) {
		int resultado = 0;
		while (palavra.length() > 0){
			char algarismo = palavra.charAt(0);
			resultado = resultado * 10 + (algarismo - '0');
			palavra = palavra.substring(1);
		}
		return resultado;
	}

	public static void main(String[] args) {
		Palavra palavra = new Palavra();
		System.out.println(palavra.converteParaNumero("1584"));		
	}
}