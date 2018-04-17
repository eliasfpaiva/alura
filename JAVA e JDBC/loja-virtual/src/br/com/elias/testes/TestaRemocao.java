package br.com.elias.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.elias.jdbc.ConnectionPool;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			connection.setAutoCommit(false);
			String sql = "delete from produto where id > ?";
			
			try (PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setInt(1, 10);
				statement.execute();
				System.out.println(statement.getUpdateCount() + " linhas atualizadas");
				connection.commit();
			}catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Fedeu aqui, desfizemos tudo! RollBack efetuado");
			}
		}
	}

}
