package br.com.elias.models;

import java.util.List;

public class Venda {

	String formaDePagamento;
	List<Produto> produtos;
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	@Override
	public String toString() {
		return "Venda [formaDePagamento=" + formaDePagamento + ", produtos=" + produtos + "]";
	}	
}
