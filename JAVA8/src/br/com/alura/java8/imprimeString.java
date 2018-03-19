package br.com.alura.java8;

import java.util.function.Consumer;

public class imprimeString implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(s);
	}	
}