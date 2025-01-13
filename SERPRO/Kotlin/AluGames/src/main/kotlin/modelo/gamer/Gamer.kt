package modelo.gamer

import Utils.ValidarEmail
import kotlin.random.Random

data class Gamer(var nome:String, var email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) criarIdInterno()
        }
    var idInterno:String? = null
        private set

    constructor(nome: String, email: String, dataNascimento:String, usuario:String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }
    
    init {
        this.email = ValidarEmail(this.email)
        validarNome(this.nome)
    }

    private fun validarNome(nome: String?) {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        this.idInterno = String.format("$usuario%04d", numero)
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }
}