package modelo.aluguel

import modelo.jogador.paraEntidade
import modelo.jogador.paraJogador
import modelo.jogo.paraEntidade
import modelo.jogo.paraJogo

fun Aluguel.paraEntidade(): AluguelEntity {
    val aluguel = this
    val aluguelEntity = AluguelEntity(aluguel.jogador.paraEntidade(), aluguel.jogo.paraEntidade(), aluguel.periodo)
    return aluguelEntity.apply { id = aluguel.id; valorDoAluguel = aluguel.valor }
}

fun AluguelEntity.paraAluguel(): Aluguel {
    val entidade = this
    val aluguel = Aluguel(entidade.jogador.paraJogador(), entidade.jogo.paraJogo(), entidade.periodo)
    return aluguel.apply { id = entidade.id }
}