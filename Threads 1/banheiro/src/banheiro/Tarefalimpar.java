package banheiro;

public class Tarefalimpar implements Runnable {

	private Banheiro banheiro;

	public Tarefalimpar(Banheiro banheiro) { this.banheiro = banheiro; }

	@Override
	public void run() {
		
		while(true) { 
			this.banheiro.limpa();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
