package modelo.aluguel

import modelo.jogador.JogadorEntity
import modelo.jogo.JogoEntity
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "aluguel")
class AluguelEntity(
    @ManyToOne
    val jogador: JogadorEntity = JogadorEntity(),
    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo.gerarPorNumeroDeDias(7)
) {
    var valorDoAluguel = BigDecimal.ZERO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}