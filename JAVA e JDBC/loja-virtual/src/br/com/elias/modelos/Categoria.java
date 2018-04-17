package br.com.elias.modelos;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int id;
	private String nome;
	private final List<Produto> produtos = new ArrayList<>();
	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public int    		 getId()  	   { return id; }
	public String 		 getNome() 	   { return nome; }		
	public List<Produto> getProdutos() { return produtos; }
	
	public void addProduto(Produto produto) { this.produtos.add(produto); }
	
	@Override
	public String toString() { return "Categoria [id=" + id + ", nome=" + nome + "]"; }
	
}
