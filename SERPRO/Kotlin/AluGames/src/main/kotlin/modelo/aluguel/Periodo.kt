package modelo.aluguel

import java.time.LocalDate
import java.time.Period

data class Periodo(val inicio: LocalDate = LocalDate.now(), val fim: LocalDate = LocalDate.now().plusDays(7)){
    fun emDias(): Int { return Period.between(inicio, fim).days }
    fun inicioNoMes(mes: Int, ano: Int): Boolean { return inicio.monthValue.equals(mes) && inicio.year.equals(ano) }
    fun fimNoMes(mes: Int, ano: Int): Boolean { return fim.monthValue.equals(mes) && fim.year.equals(ano) }

    companion object{
        fun gerarPorNumeroDeDias(dias: Int): Periodo {
            return Periodo(LocalDate.now(), LocalDate.now().plusDays(dias.toLong()))
        }
    }
}
