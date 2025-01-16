package modelo.jogo

import Utils.numeroCasasDecimais
import com.google.gson.annotations.Expose
import modelo.Recomendavel

data class Jogo(@Expose val titulo: String, @Expose val capa: String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    override val notas: MutableList<Int> = mutableListOf()
    override val mediaRecomendacao: Double
        get() = if (notas.isEmpty()) 0.0 else notas.average()

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
                "Reputação: ${mediaRecomendacao.numeroCasasDecimais(2)}"
    }
}