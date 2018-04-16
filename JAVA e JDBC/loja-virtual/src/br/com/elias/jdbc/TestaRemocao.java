package br.com.elias.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			connection.setAutoCommit(false);
			String sql = "delete from produto where id > ?";
			
			try (PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setInt(1, 90);
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
