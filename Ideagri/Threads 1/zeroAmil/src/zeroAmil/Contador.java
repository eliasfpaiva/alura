package zeroAmil;

public class Contador implements Runnable {

	@Override
	public void run() {

		for(int i = 0; i <= 1000; i++)
			System.out.println(i + " ID: " + Thread.currentThread().getId() );
	}
}
