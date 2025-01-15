package Utils

import modelo.jogador.Jogador
import modelo.jogador.InfoJogadorJson

fun InfoJogadorJson.toJogador(): Jogador { return Jogador(this.nome, this.email, this.dataNascimento, this.usuario) }