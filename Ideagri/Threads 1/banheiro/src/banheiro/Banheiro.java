package banheiro;

public class Banheiro {
	
	private boolean sujo = true; 

	public void fazNumero1() {
		
		String nomeConvidado = Thread.currentThread().getName();
    	System.out.println(nomeConvidado + " bate na porta");
    	
		synchronized (this) {			
			
	        System.out.println(nomeConvidado + " entrando no banheiro");
	        
	        while(sujo) {
	        	estaSujo();
	        }
	        
	        System.out.println(nomeConvidado + " fazendo coisa rapida");
	        sujo = true;

	        espera(8000);

	        System.out.println(nomeConvidado + " dando descarga");
	        System.out.println(nomeConvidado + " lavando as mãos");
	        System.out.println(nomeConvidado + " saindo do banheiro");
		}
    }
	
    public void fazNumero2() {

    	String nomeConvidado = Thread.currentThread().getName();
    	System.out.println(nomeConvidado + " bate na porta");

    	synchronized (this) {
        	
        	System.out.println(nomeConvidado + " entrando no banheiro");
	        
	        while(sujo) {
	        	estaSujo();
	        }
	        
            System.out.println(nomeConvidado + " fazendo coisa demorada");
	        sujo = true;

            espera(15000);

            System.out.println(nomeConvidado + " dando descarga");
            System.out.println(nomeConvidado + " lavando as mãos");
            System.out.println(nomeConvidado + " saindo do banheiro");
		}
    }
    
    public void limpa() {
    	String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");

            if (!this.sujo) {
                System.out.println(nome + ", não está sujo, vou sair");
                return;
            }

            System.out.println(nome + " limpando o banheiro");
            this.sujo = false;

            espera(13000);

            this.notifyAll();

            System.out.println(nome + " saindo do banheiro");
        }

    }

	private void espera(long time) {
		try {
		    Thread.sleep(time);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

	private void estaSujo() {
		System.out.println("Está sujo!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
