package modelo.jogador

import javax.persistence.*

@Entity
@Table(name = "jogadores")
data class JogadorEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val dataNascimento:String? = null,
    val usuario:String? = null) {

    fun paraJogador() = Jogador(id = this.id, nome = this.nome, email = this.email, dataNascimento = this.dataNascimento ?: "", usuario = this.usuario ?: "")

    companion object {
        fun doJogador(jogador: Jogador) = JogadorEntity(id = jogador.id ?: 0, nome = jogador.nome, email = jogador.email, dataNascimento = jogador.dataNascimento, usuario = jogador.usuario)
    }
}