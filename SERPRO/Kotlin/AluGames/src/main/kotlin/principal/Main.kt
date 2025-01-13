package principal

import com.google.gson.Gson
import modelo.gamer.Gamer
import servicos.ConsultaJogos
import java.util.*

fun main(){

    val scanner = Scanner(System.`in`)
    val gamer = Gamer.cadastrarGamer(scanner)
    do {
        gamer.jogosBuscados.add(ConsultaJogos.consultaPorId())
        println(Gson().toJson(gamer))
        print("Se desejar realizar uma nova consulta digite 's': ")
    }while (scanner.nextLine().equals("s", true))
}