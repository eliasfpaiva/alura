package modelo.aluguel

import modelo.jogador.Jogador
import modelo.jogo.Jogo

data class Aluguel(val jogador: Jogador, val jogo: Jogo, val periodo: Periodo){
    val valor = jogo.preco * periodo.emDias()
    override fun toString(): String {
        return "${jogador.nome} alugou ${jogo.titulo} no dia ${periodo.inicio} para devolução dia ${periodo.fim} por R$$valor"
    }

    fun ehNoMes(mes: Int, ano: Int): Boolean { return periodo.inicioNoMes(mes, ano) }
}