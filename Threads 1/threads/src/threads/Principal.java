package threads;

import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) {
		
		List<String> lista = new Vector<>();
		
		for(int i = 0; i<10; i++)
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		
		lista.forEach(System.out::println);
	}
}
