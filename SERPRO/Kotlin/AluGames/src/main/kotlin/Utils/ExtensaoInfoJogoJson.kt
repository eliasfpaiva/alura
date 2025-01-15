package Utils

import modelo.jogo.InfoJogoJson
import modelo.jogo.Jogo

fun InfoJogoJson.toJogo(): Jogo { return Jogo(this.titulo, this.capa, this.preco, this.descricao) }