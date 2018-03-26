package br.com.alura.java2.api;

import java.util.LinkedList;

public class RegistroDeMensagens {

	public static void main(String[] args) throws InterruptedException{
		LinkedList<String> mensagens = new LinkedList<>();
		
		Thread t1 = new Thread(new ProduzMensagens(0, 10000, mensagens));
		Thread t2 = new Thread(new ProduzMensagens(10000, 20000, mensagens));
		Thread t3 = new Thread(new ProduzMensagens(20000, 30000, mensagens));
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Todas as Threads produtoras de mensagens foram finalizadas!");
		
		for(int i = 0; i < 30000; i++) {
			if(!mensagens.contains("Mensagem " + i))
				throw new IllegalStateException("N�o encontrei a mensagem: " + i);
		}
		
		if(mensagens.contains(null))
			throw new IllegalStateException("N�o devia ter null aqui dentro!");
		
		System.out.println("Fim da execu��o com sucesso");
	}
}
