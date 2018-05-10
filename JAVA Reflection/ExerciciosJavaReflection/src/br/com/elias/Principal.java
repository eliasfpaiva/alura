package br.com.elias;

import java.util.List;

public class Principal {

	public static void main(String[] args) {

		Produto produto = new Produto(1, "Produto", null, "Produto de teste", 10);
		Usuario user = new Usuario("elias", "1234", "teste@teste.com.br", "tester", true);
		NotaFiscal nf = new NotaFiscal(10, 25, "00.111.222.333/4444.55", "lugar", null);
		@SuppressWarnings("unused")
		List<String> lista;

		System.out.println("Inicio teste");

		lista = TestaValidacao.buscaString(nf, "Produto");
		System.out.println("Inicio teste nf");
		//
		// for (String string : lista) {
		// System.out.println(string);
		// }
		lista = TestaValidacao.buscaString(user, "Produto");
		System.out.println("Inicio teste user");
		//
		// for (String string : lista) {
		// System.out.println(string);
		// }
		lista = TestaValidacao.buscaString(produto, "Produto");
		System.out.println("Inicio teste Produto");
		//
		// for (String string : lista) {
		// System.out.println(string);
		// }
		// System.out.println("Fim teste");
	}
}
