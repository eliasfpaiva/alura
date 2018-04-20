package br.com.pilha.testes;
import br.com.pilha.modelo.Conta;
import br.com.pilha.modelo.MinhaExcecao;

public class TestaContaComExcecaoChecked {

	public static void main(String[] args) {

		Conta c = new Conta();
		try {
			c.deposita();
		} catch(MinhaExcecao ex) {
			System.out.println("tratamento ....");
		}
	
	}

}
