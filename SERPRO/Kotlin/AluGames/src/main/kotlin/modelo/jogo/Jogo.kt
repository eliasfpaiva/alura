package modelo.jogo

import com.google.gson.annotations.Expose
import modelo.Recomendavel
import java.math.BigDecimal

data class Jogo(@Expose val titulo: String, @Expose val capa: String): Recomendavel {
    var id: Int? = 0
    var descricao: String? = null
    var preco = BigDecimal("0.0")
    override val notas: MutableList<Int> = mutableListOf()
    override val mediaRecomendacao: BigDecimal
        get() = if (notas.isEmpty()) BigDecimal("0.0") else (notas.sum().toBigDecimal() / notas.size.toBigDecimal())

    constructor(id: Int?, titulo: String, capa: String, preco: BigDecimal, descricao: String):
            this(titulo, capa) {
        this.id = id
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Id: $id\n" +
                "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao\n" +
                "Preço: $preco\n" +
                "Reputação: ${mediaRecomendacao.setScale(2)}"
    }
}