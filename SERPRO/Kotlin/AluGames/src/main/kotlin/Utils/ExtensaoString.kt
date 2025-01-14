package Utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataNascimento = LocalDate.parse(this, formatter)
    return Period.between(dataNascimento, LocalDate.now()).years
}