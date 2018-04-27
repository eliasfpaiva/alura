package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaSaidas implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBD;
	private PrintStream saida;

	public JuntaSaidas(Future<String> futureWS, Future<String> futureBD, PrintStream saida) {
		this.futureWS = futureWS;
		this.futureBD = futureBD;
		this.saida = saida;
	}

	@Override
	public Void call() throws Exception {
		
		saida.println("Aguardando resultados!");
		
		try {
			String numero1 = this.futureWS.get(20, TimeUnit.SECONDS);
			String numero2 = this.futureBD.get(20, TimeUnit.SECONDS);
			
			this.saida.println("Resultado dos comando " + numero1 + " e " + numero2);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {

            System.out.println("Timeout: Cancelando a execução do comando c2");

            this.saida.println("Timeout na execução do comando c2");
            this.futureWS.cancel(true);
            this.futureBD.cancel(true);
    		System.out.println("Finalizou JuntaResultados");
        }
		
		
		return null;
	}

}
