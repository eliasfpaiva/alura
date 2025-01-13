package principal

import modelo.Jogo
import servicos.ConsultaJogos
import servicos.ConsumoApi
import java.util.*

fun main(){
    do {
        ConsultaJogos().consultaPorId()
        print("Se desejar realizar uma nova consulta digite 's': ")
    }while (Scanner(System.`in`).nextLine().equals("s", true))
}