package modelo.plano

import modelo.aluguel.Aluguel
import modelo.jogador.Jogador

sealed class Plano(val tipo: TiposPlano) {
    open fun obterValor(aluguel: Aluguel): Double {
        val valor = aluguel.jogo.preco * aluguel.periodo.emDias()
        return valor - (valor * percentualDesconto(aluguel.jogador))
    }
    abstract fun percentualDesconto(jogador: Jogador): Double
}