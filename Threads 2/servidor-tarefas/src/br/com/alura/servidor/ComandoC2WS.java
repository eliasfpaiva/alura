package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2WS implements Callable<String> {

	private PrintStream saida;

	public ComandoC2WS(PrintStream saida) { this.saida = saida; }

	@Override
	public String call() throws Exception {
		
		System.out.println("Servidor recebeu comando C2 - WS!");
		
		saida.println("Processando comando C2 - WS!");
		
		Thread.sleep(15000);
		
		int numero = new Random().nextInt(101);
		
		System.out.println("Servidor finalizou o comando C2 - WS");
		
		return Integer.toString(numero);
	}

}
