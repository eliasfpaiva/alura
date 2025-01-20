package modelo.aluguel

import modelo.jogador.Jogador
import modelo.jogo.Jogo

data class Aluguel(val jogador: Jogador, val jogo: Jogo, val periodo: Periodo){
    var id = 0
    val valor = jogador.plano.obterValor(this)
    override fun toString(): String {
        return "${jogador.nome} alugou ${jogo.titulo} e Id $id no dia ${periodo.inicio} para devolução dia ${periodo.fim} por R$${valor.setScale(2)}"
    }

    fun ehNoMes(mes: Int, ano: Int): Boolean { return periodo.inicioNoMes(mes, ano) }
}