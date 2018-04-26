package br.com.alura.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida " + socket.getPort());
				
		PrintStream saida = new PrintStream(socket.getOutputStream());
		
		Thread threadEntrada = new Thread( () -> {
			Scanner teclado = new Scanner(System.in);
			while(teclado.hasNextLine()) {
				String linha = teclado.nextLine();
				if(linha.equals(""))
					break;
				saida.println(linha);
			}
			teclado.close();			
		});

		Thread treadSaida = new Thread( () -> {
			try (Scanner respostaServidor = new Scanner(socket.getInputStream())) {					
				while(respostaServidor.hasNextLine()) {
					String linha = respostaServidor.nextLine();
					System.out.println(linha);
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
		
		threadEntrada.start();
		treadSaida.start();
		
		threadEntrada.join();
		
		System.out.println("Conexão encerrada");
		
		saida.close();
		socket.close();
	}
}
