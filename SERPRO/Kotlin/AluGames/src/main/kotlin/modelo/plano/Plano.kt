package modelo.plano

import modelo.aluguel.Aluguel

sealed class Plano(val tipo: TiposPlano) {
    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias()
    }
}