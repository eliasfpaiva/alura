package Utils

fun ValidarEmail(email: String): String {
    val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    if (regex.matches(email)) {
        return email
    } else {
        throw IllegalArgumentException("Email inválido")
    }
}