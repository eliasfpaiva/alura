package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
	private ServerSocket 		  servidor;
	private ExecutorService 	  poolThreads;
	private AtomicBoolean 		  estaRodando;
	private BlockingQueue<String> filaComandos;

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando Servidor ----");
		this.servidor     = new ServerSocket(12345);
		this.poolThreads  = Executors.newFixedThreadPool(4, new FabricaThreads());
		this.estaRodando  = new AtomicBoolean(false);
		this.filaComandos = new ArrayBlockingQueue<>(2);
		iniciarConsumidores();
	}
	
	public void rodar() throws IOException {
		estaRodando.set(true);
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				poolThreads.execute(new DistribuirTarefas(socket, this, poolThreads, this.filaComandos));
			} catch (Exception e) { }
		}
	}
	
	public void parar() throws IOException {
		System.out.println("Parando o servidor!");
		this.estaRodando.set(false);
		this.poolThreads.shutdown();
		this.servidor.close();
	}
	
	public void iniciarConsumidores() {
		int qtdConsumidores = 2;
		for(int i = 0; i<qtdConsumidores; i++) {
			this.poolThreads.execute(new TarefaConsumir(this.filaComandos));
		}
	}
	
	public static void main(String[] args) throws Exception {

		new ServidorTarefas().rodar();
	}
}
