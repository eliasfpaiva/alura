package br.com.alura.java2.api;

import java.util.LinkedList;

public class ProduzMensagens implements Runnable {

	private int comeco;
	private int fim;
	private LinkedList<String> mensagens;

	public ProduzMensagens(int comeco, int fim, LinkedList<String> mensagens) {
		this.comeco = comeco;
		this.fim = fim;
		this.mensagens = mensagens;
	}

	public void run() {
		for (int i = comeco; i < fim; i++) {
			//synchronized (mensagens) {
				mensagens.add("Mensagem " + i);
			//}
		}
	}
}
