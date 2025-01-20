package modelo.plano

import modelo.jogador.Jogador
import java.math.BigDecimal

class PlanoPadrao(id: Int = 0): Plano(id, TiposPlano.BRONZE) {
    override fun percentualDesconto(jogador: Jogador): BigDecimal {
        return if(jogador.mediaRecomendacao > BigDecimal("8")) BigDecimal("0.1") else BigDecimal("0.0")
    }
}