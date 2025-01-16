package modelo

interface Recomendavel {
    val notas: MutableList<Int>
    val mediaRecomendacao: Double

    fun recomendar(nota: Int){
        if (nota < 1 || nota > 10)
            println("As notas devem estar entre 1 e 10")
        else
            notas.add(nota)
    }
}