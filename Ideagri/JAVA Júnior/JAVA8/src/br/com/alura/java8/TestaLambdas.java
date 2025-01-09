package br.com.alura.java8;

import java.util.ArrayList;
import java.util.List;

//import static java.util.Comparator.*;

public class TestaLambdas {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		palavras.forEach(System.out::println);
		
//		palavras.sort(comparing(String::length));
//		
//		palavras.forEach(System.out::println);
		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
//		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		
//		palavras.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//			
//		});
		
//		palavras.forEach(s -> System.out.println(s));
		
//		palavras.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String s1, String s2) {
//				if(s1.length()>s2.length())
//					return 1;
//				else if(s1.length()<s2.length())
//					return -1;
//				return 0;
//			}
//		});
		
//		palavras.sort((s1, s2) -> s1.length() - s2.length());
//		
//		palavras.forEach(s -> System.out.println(s));
		
//		Consumer<String> consumidor = new imprimeString();
//		
//		palavras.forEach(consumidor);
//		
//		Comparator<String> comparadorDeTamanho = new Comparatamanho();
//		
//		palavras.sort(comparadorDeTamanho);
//		
//		palavras.forEach(consumidor);
	}
}