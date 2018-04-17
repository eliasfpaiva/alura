package br.com.elias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.elias.modelos.Categoria;
import br.com.elias.modelos.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salva(Produto produto) throws SQLException {
		String nome = produto.getNome();
		String descricao = produto.getDescricao();

		String sql = "insert into produto (nome, descricao) values (?, ?)";
		this.connection.setAutoCommit(false);

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, nome);
			statement.setString(2, descricao);
			statement.execute();

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				produto.setId(resultSet.getInt("id"));
			}
			resultSet.close();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("Deu caca e foi feito o Roloback!");
		}
	}

	public List<Produto> lista() {
		String sql = "select * from Produto";
		List<Produto> produtos = new ArrayList<>();

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();
			
			transformaResultadoEmProdutos(produtos, statement);
			
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu erro");
			return null;
		}
	}
	
	public List<Produto> busca(Categoria categoria){
		String sql = "select * from Produto where categoria_id=?";
		List<Produto> produtos = new ArrayList<>();

		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, categoria.getId());
			statement.execute();
			
			transformaResultadoEmProdutos(produtos, statement);
			
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu erro" + e.getMessage());
			return null;
		}
	}

	private void transformaResultadoEmProdutos(List<Produto> produtos, PreparedStatement statement)
			throws SQLException {
		try (ResultSet resultSet = statement.getResultSet()) {

			while (resultSet.next()) {
				Produto novo = new Produto(resultSet.getInt("id"), resultSet.getString("nome"),
						resultSet.getString("descricao"));
				produtos.add(novo);
			}
		}
	}
}
