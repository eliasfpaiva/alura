package br.com.elias.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.elias.DAO.CategoriaDAO;
import br.com.elias.jdbc.ConnectionPool;
import br.com.elias.modelos.Categoria;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			List<Categoria> categorias = new CategoriaDAO(connection).lista();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
			}
		}
	}
}
