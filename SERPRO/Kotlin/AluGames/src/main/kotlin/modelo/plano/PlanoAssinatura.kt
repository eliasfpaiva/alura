package modelo.plano

import modelo.aluguel.Aluguel
import modelo.jogador.Jogador
import java.math.BigDecimal

class PlanoAssinatura(tipo: TiposPlano, val mesalidade: BigDecimal, val jogosIncluidos: Int, val percentualDescontoReputacao: BigDecimal, id:Int = 0): Plano(tipo, id) {
    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val totalJogosNoMes = aluguel.jogador.jogosAlugadosNoMes(aluguel.periodo.inicio).size + 1

        return if (totalJogosNoMes <= jogosIncluidos) { BigDecimal("0.0") } else { super.obterValor(aluguel) }
    }
    override fun percentualDesconto(jogador: Jogador): BigDecimal {
        return if(jogador.mediaRecomendacao > BigDecimal("8")) percentualDescontoReputacao else BigDecimal("0.0")
    }

    override fun toString(): String {
        return "PlanoAssinatura(mesalidade=$mesalidade, jogosIncluidos=$jogosIncluidos, percentualDescontoReputacao=$percentualDescontoReputacao)"
    }
}