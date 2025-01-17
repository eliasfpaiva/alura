package Utils

import modelo.jogador.InfoJogadorJson
import modelo.jogador.Jogador

fun InfoJogadorJson.toJogador(): Jogador { return Jogador(null, this.nome, this.email, this.dataNascimento, this.usuario) }