package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2BD implements Callable<String> {

	private PrintStream saida;

	public ComandoC2BD(PrintStream saida) { this.saida = saida; }

	@Override
	public String call() throws Exception {
		
		System.out.println("Servidor recebeu comando C2 - Banco!");
		
		saida.println("Processando comando C2 - Banco!");
		
		Thread.sleep(15000);
		
		int numero = new Random().nextInt(101);
		
		System.out.println("Servidor finalizou o comando C2 - Banco");
		
		return Integer.toString(numero);
	}

}
