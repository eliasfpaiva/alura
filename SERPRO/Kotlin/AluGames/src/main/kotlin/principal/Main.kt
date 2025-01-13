package principal

import modelo.gamer.Gamer
import java.util.*
import kotlin.jvm.internal.Intrinsics

fun main(){
    val gamers = arrayListOf<Gamer>()
    gamers.add(Gamer("Nome${gamers.size}", "email${gamers.size}@jacu.com"))
    gamers.add(Gamer("Nome${gamers.size}", "email${gamers.size}@jacu.com", "01/01/1900", "bacurau"))
    gamers.forEach{println(it)}

    gamers.get(1).usuario = "jubileu"
    gamers.forEach{println(it)}

//    do {
//
//        print("Se desejar incluir outro Gamer digite 's': ")
//    }while (Scanner(System.`in`).nextLine().equals("s", true))
//    do {
//        ConsultaJogos().consultaPorId()
//        print("Se desejar realizar uma nova consulta digite 's': ")
//    }while (Scanner(System.`in`).nextLine().equals("s", true))
}