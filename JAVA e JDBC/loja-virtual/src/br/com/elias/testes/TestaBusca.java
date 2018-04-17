package br.com.elias.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.elias.DAO.CategoriaDAO;
import br.com.elias.DAO.ProdutoDAO;
import br.com.elias.jdbc.ConnectionPool;
import br.com.elias.modelos.Categoria;
import br.com.elias.modelos.Produto;

public class TestaBusca {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionPool().getConnection();
		CategoriaDAO cDao = new CategoriaDAO(connection);
		for (Categoria c : cDao.lista()) {
			System.out.println(c.toString());
			for (Produto p : new ProdutoDAO(connection).busca(c))
				System.out.println(p.toString());
		}
	}

}
