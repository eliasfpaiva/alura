package modelo.plano

import modelo.aluguel.Aluguel
import modelo.jogador.Jogador

class PlanoAssinatura(tipo: TiposPlano, val mesalidade: Double, val jogosIncluidos: Int, val percentualDescontoReputacao: Double): Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.jogador.jogosAlugadosNoMes(aluguel.periodo.inicio).size + 1

        return if (totalJogosNoMes <= jogosIncluidos) { 0.0 } else { super.obterValor(aluguel) }
    }
    override fun percentualDesconto(jogador: Jogador): Double {
        return if(jogador.mediaRecomendacao > 8) percentualDescontoReputacao else 0.0
    }
}