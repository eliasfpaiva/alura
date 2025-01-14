package principal

import modelo.gamer.Gamer
import java.util.*

fun main(){

    val scanner = Scanner(System.`in`)
    val gamer = Gamer.cadastrarGamer(scanner)

    gamer.incluirGame(scanner)
    gamer.removerGame(scanner)
}