package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
	private ServerSocket servidor;
	private ExecutorService poolThreads;
	private AtomicBoolean estaRodando;

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando Servidor ----");
		this.servidor = new ServerSocket(12345);
		this.poolThreads = Executors.newFixedThreadPool(4, new FabricaThreads());
		this.estaRodando = new AtomicBoolean(false);
	}
	
	public void rodar() throws IOException {
		estaRodando.set(true);
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				poolThreads.execute(new DistribuirTarefas(socket, this, poolThreads));
			} catch (Exception e) { }
		}
	}
	
	public void parar() throws IOException {
		System.out.println("Parando o servidor!");
		this.estaRodando.set(false);
		this.poolThreads.shutdown();
		this.servidor.close();
	}
	
	public static void main(String[] args) throws Exception {

		new ServidorTarefas().rodar();
	}
}
