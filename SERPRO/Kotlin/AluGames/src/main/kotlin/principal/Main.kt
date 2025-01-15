package principal

import servicos.ConsumoApi

fun main(){
    println(ConsumoApi().buscaJogadores())
    println(ConsumoApi().buscaJogos())
}