package br.com.alura.cursos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TesteListas {

	public static void main(String[] args) {
		System.out.println("**************ArrayList vs LinkedList**************");
		
		List<Integer> numerosArrayList = new ArrayList<>();
		List<Integer> numerosLinkedList = new LinkedList<>();
		
		int quantideDeElementos = 1000000;
		Long tempoArrayList = insereElementosNo(numerosArrayList, quantideDeElementos);
		Long tempoLinkedList = insereElementosNo(numerosLinkedList, quantideDeElementos);
		
		System.out.println("A inserção no ArrayList demorou: " + tempoArrayList);
		
		tempoArrayList = removePrimeirosElementos(numerosArrayList);
		
		System.out.println("A remoção no ArrayList demorou: " + tempoArrayList);
		
		System.out.println("A inserção no LinkedList demorou: " + tempoLinkedList);
		
		tempoLinkedList = removePrimeirosElementos(numerosLinkedList);
		
		
		System.out.println("A remoção no LinkedList demorou: " + tempoLinkedList);
	}
	
	private static long removePrimeirosElementos(List<Integer> numeros) {
		long ini = System.currentTimeMillis();
		
		for(int i=0; i<100; i++) {
			numeros.remove(0);
		}

		long fim = System.currentTimeMillis();
		return fim-ini;
	}
	
	private static long insereElementosNo(List<Integer> numeros, int quantidade) {
		long ini = System.currentTimeMillis();
		
		for(int i=0; i<quantidade; i++) {
			numeros.add(i);
		}

		long fim = System.currentTimeMillis();
		return fim-ini;		
	}
}
