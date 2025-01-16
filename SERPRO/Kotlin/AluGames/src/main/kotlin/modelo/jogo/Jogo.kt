package modelo.jogo

import modelo.Recomendavel

data class Jogo(val titulo: String, val capa: String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    private val notas = mutableListOf<Int>()
    override val mediaRecomendacao: Double
        get() = if (notas.isEmpty()) 0.0 else notas.average()

    override fun recomendar(nota: Int) { notas.add(nota) }

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao\n" +
                "Preço: $preco\n" +
                "Reputação: $mediaRecomendacao"
    }
}