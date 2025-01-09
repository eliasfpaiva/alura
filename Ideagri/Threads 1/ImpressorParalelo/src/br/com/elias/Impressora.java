package br.com.elias;

public class Impressora implements Runnable{

	String s;
	
	public Impressora(String s) { this.s = s; }
	
	@Override
	public void run() { 
		System.out.println(this.s); 
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
