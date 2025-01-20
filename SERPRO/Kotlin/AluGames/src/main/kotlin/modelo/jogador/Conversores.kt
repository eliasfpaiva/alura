package modelo.jogador

fun Jogador.paraEntidade() = JogadorEntity(id = this.id ?: 0, nome = this.nome, email = this.email, dataNascimento = this.dataNascimento, usuario = this.usuario)

fun JogadorEntity.paraJogador() = Jogador(id = this.id, nome = this.nome, email = this.email, dataNascimento = this.dataNascimento ?: "", usuario = this.usuario ?: "")