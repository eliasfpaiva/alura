package Utils

import java.util.*

fun validarEmail(email: String): String {
    val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    if (regex.matches(email)) {
        return email
    } else {
        throw IllegalArgumentException("Email inválido")
    }
}

fun solicitarOpcaoString(leitura: Scanner, mensagem: String?): String {
    print(mensagem ?: "Digite a sua opção: ")
    return leitura.nextLine()
}

fun solicitarOpcaoInt(leitura: Scanner, mensagem: String?): Int {
    print(mensagem ?: "Digite um número inteiro: ")
    val valor = leitura.nextInt()
    leitura.nextLine()
    return valor
}

fun repetirString(numeroRepeticoes: Int, string: String): String {
    return if(numeroRepeticoes == 0) "" else "$string${repetirString(numeroRepeticoes - 1, string)}"
}