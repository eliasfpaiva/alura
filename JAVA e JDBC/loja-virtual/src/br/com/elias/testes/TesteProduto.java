package br.com.elias.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.elias.DAO.ProdutoDAO;
import br.com.elias.jdbc.ConnectionPool;
import br.com.elias.modelos.Produto;

public class TesteProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto novo = new Produto("Mesa Vermelha", "Mesa com 4 pés");
		
		try(Connection connection = new ConnectionPool().getConnection()){
			ProdutoDAO dao = new ProdutoDAO(connection);
			dao.salva(novo);
			dao.lista();
		}
	}

}
