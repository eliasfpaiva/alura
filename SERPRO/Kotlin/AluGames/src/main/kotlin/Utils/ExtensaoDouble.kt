package Utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.numeroCasasDecimais(numeroCasasDecimais: Int): Double{
    return DecimalFormat("#.${repetirString(numeroCasasDecimais, "#")}", DecimalFormatSymbols(Locale.ENGLISH)).format(this).toDouble()
}