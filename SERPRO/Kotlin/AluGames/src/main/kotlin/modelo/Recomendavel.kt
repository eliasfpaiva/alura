package modelo

interface Recomendavel {
    val mediaRecomendacao: Double

    fun recomendar(nota: Int)
}