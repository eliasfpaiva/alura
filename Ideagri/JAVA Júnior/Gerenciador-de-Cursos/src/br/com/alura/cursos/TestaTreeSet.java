package br.com.alura.cursos;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestaTreeSet {

	public static void main(String[] args) {
				
		Set<String> palavras = new TreeSet<>();
		
		palavras.add("testa1");
		palavras.add("testa2");
		palavras.add("testa3");
		palavras.add("testa4");
		palavras.add("testa5");
		palavras.add("testa6");
		palavras.add("testa7");
		
		Iterator<String> iterator = palavras.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
				
	}
}
