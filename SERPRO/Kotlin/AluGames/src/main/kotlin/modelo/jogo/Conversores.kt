package modelo.jogo

fun Jogo.paraEntidade() = JogoEntity(id = this.id ?: 0, titulo = this.titulo, capa = this.capa, preco = this.preco, descricao = this.descricao)

fun JogoEntity.paraJogo(): Jogo = Jogo(this.id, this.titulo, this.capa, this.preco, this.descricao ?: "")