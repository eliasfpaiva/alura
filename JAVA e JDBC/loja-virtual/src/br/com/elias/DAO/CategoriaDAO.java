package br.com.elias.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.elias.modelos.Categoria;
import br.com.elias.modelos.Produto;

public class CategoriaDAO {

	private final Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> lista() throws SQLException {
		String sql = "select * from categoria";
		List<Categoria> categorias = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			try (ResultSet resultSet = statement.getResultSet()) {

				while (resultSet.next()) {

					categorias.add(new Categoria(resultSet.getInt("id"), resultSet.getString("nome")));
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		String sql = /*"select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome,"
				+ " p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id"*/
				"select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as"
				+ " p_descricao from Produto as p join Categoria as c on p.categoria_id = c.id order by c_id";
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			try (ResultSet resultSet = statement.getResultSet()){
				
				while (resultSet.next()) {
					int    cId   = resultSet.getInt("c_id");
					String cNome = resultSet.getString("c_nome");
					if(ultima == null || !ultima.getNome().equals(cNome)) {
						ultima = new Categoria(cId, cNome);
						categorias.add(ultima);
					}
					ultima.addProduto(new Produto(resultSet.getInt("p_id"), resultSet.getString("p_nome"), resultSet.getString("p_descricao")));
				}
			}
		}
		return categorias;
	}
}
