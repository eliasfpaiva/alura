package br.com.alura.java2.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.java2.modelos.Conta;


public class Banco {

	private List<Conta> contas = new ArrayList<>();
	private Map<String, Conta> mapa = new HashMap<>();
	
	public void adiciona(Conta c) {
		contas.add(c);
		mapa.put(c.getNome(), c);
	}
	
	public Conta pega(int posicao) {
		return contas.get(posicao);
	}
	
	public int pegaQuantidadeDeContas() {
		return contas.size();
	}
	
	public Conta buscaPorNome(String nome) {
		return mapa.get(nome);
	}
}
