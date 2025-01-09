package br.com.elias.testes;

import java.sql.SQLException;

import br.com.elias.DAO.CategoriaDAO;
import br.com.elias.jdbc.ConnectionPool;
import br.com.elias.modelos.Categoria;
import br.com.elias.modelos.Produto;

public class TestaListaComProdutos {

	public static void main(String[] args) throws SQLException {
		
		for (Categoria categoria : new CategoriaDAO(new ConnectionPool().getConnection()).listaComProdutos()) {
			System.out.println(categoria.toString());
			for (Produto produto : categoria.getProdutos()) {
				System.out.println(produto.toString());
			}
		}
	}
}
