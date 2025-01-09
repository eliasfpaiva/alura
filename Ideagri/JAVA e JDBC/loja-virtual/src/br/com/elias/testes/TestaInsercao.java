package br.com.elias.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.elias.jdbc.ConnectionPool;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionPool().getConnection()){
			String sql = "insert into produto (nome, descricao) values (?, ?)";
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				adiciona("Bazuca", "Míssel 150g", statement);
				adiciona("Granada", "Fragmentação", statement);
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
		
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
		}
		
		resultSet.close();
	}

}
