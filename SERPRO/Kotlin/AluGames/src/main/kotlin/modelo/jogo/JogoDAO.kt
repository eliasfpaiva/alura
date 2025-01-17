package modelo.jogo

import dados.DAO
import java.sql.PreparedStatement
import java.sql.ResultSet

class JogoDAO() : DAO<Jogo>{
    override val tabela: String = "jogos"

    override fun converterResultado(resultado: ResultSet) = Jogo(
        resultado.getInt("id"),
        resultado.getString("titulo"),
        resultado.getString("capa"),
        resultado.getBigDecimal("preco"),
        resultado.getString("descricao")
    )

    override fun adicionar(item: Jogo) {
        salvar(getInsert(listOf("titulo", "capa", "preco", "descricao")), item)
    }

    override fun setarParametros(statement: PreparedStatement, item: Jogo) {
        statement.setString(1, item.titulo)
        statement.setString(2, item.capa)
        statement.setBigDecimal(3, item.preco)
        statement.setString(4, item.descricao)
    }
}