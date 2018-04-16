package br.com.elias.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			String sql = "select * from Produto";

				try(PreparedStatement statement = connection.prepareStatement(sql)){
					statement.execute();
					ResultSet resultSet = statement.getResultSet();
					
					while (resultSet.next()) {
						System.out.println(resultSet.getInt("id")+ "|" + resultSet.getString("nome") + "|" + resultSet.getString("descricao"));
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("Deu erro");
				}				
		}		
	}
}