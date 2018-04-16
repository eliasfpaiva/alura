package br.com.elias.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			String sql = "insert into produto (nome, descricao) values (?, ?)";
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				adiciona("TV LCD", "32 polegadas", statement);
				adiciona("Blueray", "Full HDMI", statement);
				connection.commit();
			}catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Deu caca e foi feito o Roloback!");
			}
		}
		
	}

	public static void adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);
		
//		if (nome.equals("Blueray")) {
//            throw new IllegalArgumentException("Deu muito ruim de mais");
//        }
		
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
		}
		
		resultSet.close();
	}

}
