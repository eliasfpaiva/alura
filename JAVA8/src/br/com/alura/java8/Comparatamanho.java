package br.com.alura.java8;

import java.util.Comparator;

public class Comparatamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return s1.length()-s2.length();
	}
}
