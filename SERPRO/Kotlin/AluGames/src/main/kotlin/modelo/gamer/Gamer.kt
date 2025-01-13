package modelo.gamer

import Utils.ValidarEmail
import com.google.gson.Gson
import modelo.jogo.Jogo
import java.util.*
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
    val jogosBuscados = mutableListOf<Jogo?>()

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
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)," +
                "jogosBuscados=${Gson().toJson(jogosBuscados)})"
    }

    companion object {
        fun cadastrarGamer(leitura: Scanner): Gamer {
            println("Seja bem-vindo(a) ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer (nome, email)
            }

        }
    }
}