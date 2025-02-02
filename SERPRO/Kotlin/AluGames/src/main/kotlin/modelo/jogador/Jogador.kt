package modelo.jogador

import Utils.solicitarOpcaoInt
import Utils.solicitarOpcaoString
import Utils.transformarEmIdade
import Utils.validarEmail
import modelo.Recomendavel
import modelo.aluguel.Aluguel
import modelo.aluguel.Periodo
import modelo.jogo.Jogo
import modelo.plano.Plano
import modelo.plano.PlanoPadrao
import servicos.ConsultaJogos
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import kotlin.random.Random

data class Jogador(var nome:String, var email:String) : Recomendavel{
    var id: Int? = 0
    var dataNascimento:String? = null
        private set
    var usuario:String? = null
        private set(value) {
            field = value
            if (idInterno.isNullOrBlank()) criarIdInterno()
        }
    private var idInterno:String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosRecomendados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    override val notas: MutableList<Int> = mutableListOf()
    var plano: Plano = PlanoPadrao()
    override val mediaRecomendacao: BigDecimal
        get() = if (notas.isEmpty()) BigDecimal("0.0") else (notas.sum().toBigDecimal().divide(notas.size.toBigDecimal()))

    constructor(id: Int?, nome: String, email: String, dataNascimento:String, usuario:String): this(nome, email){
        this.id = id
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
        verificacaoIdade()
    }
    
    init {
        this.email = validarEmail(this.email)
        validarNome(this.nome)
    }

    private fun verificacaoIdade() {
        if(ehMenorDeIdade())
            println("Você é menor de idade, sendo assim haverá restrições no catálogo de jogos")
    }

    private fun ehMenorDeIdade() = dataNascimento != null && dataNascimento?.transformarEmIdade()!! < 18

    private fun validarNome(nome: String?) {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        this.idInterno = String.format("$usuario%04d", numero)
    }

    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    fun jogosAlugadosNoMes(mes: Int, ano: Int): List<Aluguel> { return jogosAlugados .filter { it -> it.ehNoMes(mes, ano) } }

    fun jogosAlugadosNoMes(data: LocalDate): List<Aluguel> { return jogosAlugadosNoMes(data.monthValue, data.year) }

    override fun toString(): String {
        return "Jogador:\n" +
                "Id: $id\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "Data Nascimento: $dataNascimento\n" +
                "Usuario: $usuario\n" +
                "IdInterno: $idInterno\n" +
                "Reputação: ${mediaRecomendacao.setScale(2, RoundingMode.HALF_EVEN)}"
    }

    fun removerJogo(leitura: Scanner){
        do {
            if(jogosBuscados.isEmpty()) return
            listarGames()
            val opcao = solicitarOpcaoString(leitura,"\nSe desejar remover algum jogo da lista digite 's':")
            val desejaRemover = opcao.equals("s", true)
            if (desejaRemover) {
                val indice = solicitarOpcaoInt(leitura,"Informe a posição do jogo que deseja excluir: ")
                if(indice >= 0 && indice < jogosBuscados.size && jogosBuscados.get(indice) != null)
                    jogosBuscados.removeAt(indice)
                else println("Posição invalida!")
            }

        }while (desejaRemover)
    }

    fun listarGames() {
        jogosBuscados.sortBy{ it?.titulo }
        println("\n")
        jogosBuscados.forEach{ println("${jogosBuscados.indexOf(it)} - ${it?.titulo}")}
    }

    fun incluirJogo(scanner: Scanner) {
        do {
            listarGames()
            ConsultaJogos.consultaPorId(scanner)
                .let { if(it?.titulo?.isNotBlank() == true) jogosBuscados.add(it) }
            print("Se desejar realizar uma nova consulta digite 's': ")
        }while (scanner.nextLine().equals("s", true))
    }

    companion object {
        fun cadastrarGamer(leitura: Scanner): Jogador {
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

                return Jogador(null, nome, email, nascimento, usuario)
            } else {
                return Jogador (nome, email)
            }

        }
    }
}