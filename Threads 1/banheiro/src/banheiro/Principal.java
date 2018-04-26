package banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread Convidado1 = new Thread(new Tarefa1(banheiro),"João");
		Thread Convidado2 = new Thread(new Tarefa2(banheiro),"Predu");
		Thread limpa1 = new Thread(new Tarefalimpar(banheiro),"Limpa 1");
		Thread Convidado4 = new Thread(new Tarefa2(banheiro),"Caca");
		Thread Convidado5 = new Thread(new Tarefa1(banheiro),"jão");

		limpa1.setDaemon(true);
		limpa1.setPriority(Thread.MAX_PRIORITY);
		limpa1.start();
		
		Convidado1 .start();
		Convidado2 .start();
		Convidado4 .start();
		Convidado5 .start();
	}
}
