package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaThreads implements ThreadFactory {
	
	private static int numero = 1;

	@Override
	public Thread newThread(Runnable r) {
		 
		Thread thread = new Thread (r, "Thread Servidor Tarefas " + numero++);
		 
		thread.setUncaughtExceptionHandler(new TratadorExcecao());
		thread.setDaemon(true);
		 
		return thread;
	}

}
