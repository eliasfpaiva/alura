package br.com.alura.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidorTarefas;
	private ExecutorService threadsPool;
	private BlockingQueue<String> filaComandos;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidorTarefas, ExecutorService threadsPool, BlockingQueue<String> filaComandos) { 
		this.socket = socket;
		this.servidorTarefas = servidorTarefas;
		this.threadsPool = threadsPool;
		this.filaComandos = filaComandos;
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
	                	ComandoC2WS c2ws = new ComandoC2WS(saida);
	                	ComandoC2BD c2bd = new ComandoC2BD(saida);
	                	
	                	Future<String> futureWS = this.threadsPool.submit(c2ws);
	                	Future<String> futureBD = this.threadsPool.submit(c2bd);
	                	
	                	this.threadsPool.submit(new JuntaSaidas(futureWS, futureBD, saida));
	                	
	                    break;
	                }
	                case "c3": {
	                	this.filaComandos.put(comando);
	                	System.out.println("Comando c3 adicionado na fila");
	                	saida.println("Comando c3 adicionado na fila");
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
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
