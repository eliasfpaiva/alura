package Utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.numeroCasasDecimais(numeroCasasDecimais: Int): Double{
    return DecimalFormat("#.${gerarCasaPadraoDecimais(numeroCasasDecimais)}", DecimalFormatSymbols(Locale.ENGLISH)).format(this).toDouble()
}

fun gerarCasaPadraoDecimais(numeroCasasDecimais: Int): String {
    return if(numeroCasasDecimais == 0) "" else "#${gerarCasaPadraoDecimais(numeroCasasDecimais - 1)}"
}