package principal

import servicos.ConsumoApi
import java.util.*

fun main(){
    println(ConsumoApi().buscaJogadores())
    println(ConsumoApi().buscaJogos())
}