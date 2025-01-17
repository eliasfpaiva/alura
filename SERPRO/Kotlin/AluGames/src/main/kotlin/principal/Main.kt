package principal

import modelo.jogo.Jogo
import modelo.jogo.JogoDAO
import java.math.BigDecimal

fun main(){
    val jogoDAO = JogoDAO()
    jogoDAO.adicionar(Jogo(null, "teste", "teste", BigDecimal("1"), "asdf"))
    println(jogoDAO.listar())
}