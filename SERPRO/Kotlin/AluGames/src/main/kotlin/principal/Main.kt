package principal

import servicos.ConsumoApi
import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    println(ConsumoApi().buscaJogadores())
    println(ConsumoApi().buscaJogos())
}