package dados

import eception.SemConexaoException
import modelo.jogo.Jogo
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

interface DAO<T> {
    val tabela: String
    fun adicionar(item: T)
    fun converterResultado(resultado: ResultSet): T
    fun setarParametros(statement: PreparedStatement, item: T)

    fun listar(): List<T> {
        val lista = mutableListOf<T>()
        acessarConexao().use { conexao ->
            val statement = conexao.createStatement()
            val resultado = statement.executeQuery(getQuerySelectAll())
            while (resultado.next()){
                lista.add(converterResultado(resultado))
            }
            statement.close()
        }
        return lista
    }

    fun salvar(insert: String, item: T) {
        acessarConexao().use { conexao ->
            val statement = conexao.prepareStatement(insert)
            setarParametros(statement, item)
            statement.executeUpdate()
            statement.close()
        }
    }

    fun acessarConexao(): Connection {
        val conexao: Connection = Banco.obterConexao() ?: throw SemConexaoException()
        return conexao
    }

    fun getQuerySelectAll() = "SELECT * FROM $tabela"
    fun getInsert(campos: List<String>): String = "INSERT INTO $tabela(${campos.joinToString(", ")}) VALUES (${campos.map { " ?" }.joinToString(separator = ", ")});"
}