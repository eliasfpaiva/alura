package modelo.jogo

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "jogos")
data class JogoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val titulo: String = "",
    val capa: String = "",
    val preco: BigDecimal = BigDecimal.ZERO,
    val descricao: String? = "")