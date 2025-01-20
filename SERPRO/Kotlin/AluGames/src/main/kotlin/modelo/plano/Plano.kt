package modelo.plano

import modelo.aluguel.Aluguel
import modelo.jogador.Jogador
import java.math.BigDecimal

sealed class Plano(var id: Int = 0, val tipoPlano: TipoPlano) {

    open fun obterValor(aluguel: Aluguel): BigDecimal {
        val valor = aluguel.jogo.preco * aluguel.periodo.emDias().toBigDecimal()
        return valor - (valor * percentualDesconto(aluguel.jogador))
    }
    abstract fun percentualDesconto(jogador: Jogador): BigDecimal

    override fun toString(): String {
        return "Plano(id=$id, tipo=$tipoPlano)"
    }
}