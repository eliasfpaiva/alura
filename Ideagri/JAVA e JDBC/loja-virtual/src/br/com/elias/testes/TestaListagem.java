package br.com.elias.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.elias.DAO.ProdutoDAO;
import br.com.elias.jdbc.ConnectionPool;
import br.com.elias.modelos.Produto;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection connection = new ConnectionPool().getConnection()){
			ProdutoDAO teste = new ProdutoDAO(connection);
			List<Produto> produtos = teste.lista();
			for (Produto produto : produtos) { System.out.println(produto.toString()); }
		
//			String sql = "select * from Produto";
//
//				try(PreparedStatement statement = connection.prepareStatement(sql)){
//					statement.execute();
//					ResultSet resultSet = statement.getResultSet();
//					
//					while (resultSet.next()) {
//						System.out.println(resultSet.getInt("id")+ "|" + resultSet.getString("nome") + "|" + resultSet.getString("descricao"));
//					}
//				}catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("Deu erro");
//				}				
		}
	}
}