package modelo.plano

import modelo.jogador.Jogador

class PlanoPadrao(): Plano(TiposPlano.BRONZE) {
    override fun percentualDesconto(jogador: Jogador): Double {
        return if(jogador.mediaRecomendacao > 8) 0.1 else 0.0
    }
}