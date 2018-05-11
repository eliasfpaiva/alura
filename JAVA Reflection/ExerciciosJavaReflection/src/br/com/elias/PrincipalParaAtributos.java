package br.com.elias;

import java.util.List;

public class PrincipalParaAtributos {

	public static void main(String[] args) throws Exception, Exception {

		Produto    produto = new Produto(1, "Produto", null, "Produto de teste", 10);

		//		Field[] fields = Produto.class.getFields();
		//		for (Field field : fields) {
		//			System.out.println(field.getName() + "|" + field.get(produto));
		//		}

		Usuario    user    = new Usuario("elias", "1234", "teste@teste.com.br", "tester", true);
		NotaFiscal nf      = new NotaFiscal(10, 25, "00.111.222.333/4444.55", "lugar", null);

		List<String> lista;

		lista = TestaValidacao.buscaString(produto, "Produto");
		System.out.println("Inicio teste Produto");

		for (String string : lista) {
			System.out.println(string);
		}

		System.out.println("Inicio teste");

		lista = TestaValidacao.buscaString(nf, "Nota");
		System.out.println("Inicio teste nf");

		for (String string : lista) {
			System.out.println(string);
		}
		lista = TestaValidacao.buscaString(user, "Usuário");
		System.out.println("Inicio teste user");

		for (String string : lista) {
			System.out.println(string);
		}
		System.out.println("Fim teste");
	}
}
