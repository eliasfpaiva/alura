package br.com.alura.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidorTarefas;
	private ExecutorService threadsPool;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidorTarefas, ExecutorService threadsPool) { 
		this.socket = socket;
		this.servidorTarefas = servidorTarefas;
		this.threadsPool = threadsPool;
	}

	@Override
	public void run() {
		
		System.out.println("Distribuindo as tarefas para o cliente " +  socket);

		try(Scanner entrada   = new Scanner(socket.getInputStream())) {
			PrintStream saida = new PrintStream(socket.getOutputStream());
			
			while(entrada.hasNext()) {
				String comando =  entrada.nextLine();
				System.out.println("Comando: " + comando);
				
				switch(comando) {
					case "c1": {
						saida.println("Confirmação do comando c1");
						ComandoC1 c1 = new ComandoC1(saida);
						this.threadsPool.execute(c1);
	                    break;
	                }
	                case "c2": {
	                	saida.println("Confirmação do comando c2");
	                	ComandoC2 c2 = new ComandoC2(saida);
						this.threadsPool.execute(c2);
	                    break;
	                }
	                case "fim": {
	                	saida.print("fim");
	                	this.servidorTarefas.parar();
	                    break;
	                }
	                default: {
	                	saida.println("Comando não encontrado");
	                }
				}
				System.out.println(comando);
			}
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
