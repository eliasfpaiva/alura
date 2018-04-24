package zeroAmil;

public class TestaZeroAMil {

	public static void main(String[] args) {
		
		new Thread(new Contador()).start();
		new Thread(new Contador()).start();
	}
}
