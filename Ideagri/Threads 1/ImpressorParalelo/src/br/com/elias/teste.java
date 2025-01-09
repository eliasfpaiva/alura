package br.com.elias;

public class teste {

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 1; i <= 30; i++) {

			Impressora imprime = new Impressora("Testando impressão " + i);
			Thread imprimindo = new Thread(imprime, "Inprimindo" + i);
			imprimindo.start();
			Thread.sleep(2000);
		}
	}
}
