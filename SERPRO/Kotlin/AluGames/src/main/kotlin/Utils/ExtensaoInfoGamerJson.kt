package Utils

import modelo.jogador.InfoJogadorJson
import modelo.jogador.Jogador

fun InfoJogadorJson.toJogador(): Jogador { return Jogador(this.nome, this.email, this.dataNascimento, this.usuario) }