package modelo.plano

import modelo.aluguel.Aluguel

class PlanoAssinatura(tipo: TiposPlano, val mesalidade: Double, val jogosIncluidos: Int): Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.jogador.jogosAlugadosNoMes(aluguel.periodo.inicio).size + 1

        return if (totalJogosNoMes <= jogosIncluidos) { 0.0 } else { super.obterValor(aluguel) }
    }
}